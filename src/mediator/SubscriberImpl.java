package mediator;

//예제2
public class SubscriberImpl extends Subscriber
{
	public SubscriberImpl(SocialMediaGroup med, String name) 
	{
		super(med, name);
	}

	@Override
	public void send(String msg) 
	{
		System.out.println(this.name+": Shared New Article on : "+msg);
		mediator.sendMessage(msg, this);
	}
 
	@Override
	public void receive(String msg) 
	{
		System.out.println(this.name+": There is new Article Available on : "+msg);
	}
}
