package mediator;

//예제2
// Mediator 
public interface SocialMediaGroup 
{
	public void sendMessage(String msg, Subscriber user);
	
	void addSubscriber(Subscriber user);
}
