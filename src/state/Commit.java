package state;

public class Commit implements Git{

	@Override
	public Git Do() {
		System.out.println("CurrentState : Commit");
		System.out.println("Git Push");
		return new Push();
	}
}
