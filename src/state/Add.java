package state;

public class Add implements Git{

	@Override
	public Git Do() {
		System.out.println("CurrentState : ADD");
		System.out.println("Git Commit");
		return new Commit();
	}
	
}
