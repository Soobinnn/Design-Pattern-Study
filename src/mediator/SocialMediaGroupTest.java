package mediator;


//예제2
public class SocialMediaGroupTest 
{
	public static void main(String[] args) 
	{
		SocialMediaGroup mediator = new LearnAndShareGroup();
		/*
		 * Creating a Subscribers 
		 */
		Subscriber subscriber1 = new SubscriberImpl(mediator, "John");
		Subscriber subscriber2 = new SubscriberImpl(mediator, "Smith");
		Subscriber subscriber3 = new SubscriberImpl(mediator, "Greg");
		Subscriber subscriber4 = new SubscriberImpl(mediator, "Devin");
		
		mediator.addSubscriber(subscriber1);
		mediator.addSubscriber(subscriber2);
		mediator.addSubscriber(subscriber3);
		mediator.addSubscriber(subscriber4);
		
		subscriber1.send("Learn Design Patterns.");
	}
}
