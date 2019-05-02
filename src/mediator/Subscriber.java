package mediator;

//예제2
// Colleague
public abstract class Subscriber 
{
	protected SocialMediaGroup mediator;
	protected String name;
	
	public Subscriber(SocialMediaGroup med, String name)
	{
		this.mediator=med;
		this.name=name;
	}
	
	public abstract void send(String msg);
	public abstract void receive(String msg);
}
