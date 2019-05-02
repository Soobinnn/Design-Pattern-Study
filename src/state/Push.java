package state;

public class Push implements Git{
	
	public Git Do() {
	System.out.println("CurrentState : PUSH");
	System.out.println("NEW FILE");
	return new NewStatus();
	}
}
