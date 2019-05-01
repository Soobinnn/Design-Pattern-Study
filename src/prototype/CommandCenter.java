package prototype;

public class CommandCenter implements Building {

	@Override
	public void abilityToDo() {
		System.out.println("It can produce SCV.");
		System.out.println("It can produce Comsat station.");
		System.out.println("It can produce Nuclear silo.");
	}

	@Override
	public Building createClone() {
		Building b = null;
		try {
			b = (Building)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return b;
	}

}
