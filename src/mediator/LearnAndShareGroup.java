package mediator;

import java.util.ArrayList;
import java.util.List;

//예제2
//ConcreteMediator
public class LearnAndShareGroup implements SocialMediaGroup
{
	private List<Subscriber> subscribers;
	 
	public LearnAndShareGroup()
	{
		this.subscribers = new ArrayList<>();
	}
 
	@Override
	public void addSubscriber(Subscriber subscriber)
	{
		this.subscribers.add(subscriber);
	}
	
	@Override
	public void sendMessage(String msg, Subscriber senderSubscriber) 
	{
		for(Subscriber subscriber : this.subscribers)
		{		
			if(subscriber != senderSubscriber)
			{
				subscriber.receive(msg);
			}
		}
	}
}
