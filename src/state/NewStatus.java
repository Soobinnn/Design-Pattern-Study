package state;

public class NewStatus implements Git{

	@Override
	public Git Do() {
		System.out.println("CurrentState : NewStatus");
		System.out.println("Git Add File");
		return new Add();
	}

}
