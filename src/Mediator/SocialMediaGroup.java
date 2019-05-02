package Mediator;

//예제1
// Mediator 
public interface SocialMediaGroup 
{
	public void sendMessage(String msg, Subscriber user);
	
	void addSubscriber(Subscriber user);
}
