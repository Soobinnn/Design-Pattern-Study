package prototype;

public class EngineeringBay implements Building {

	@Override
	public void abilityToDo() {
		System.out.println("It can upgrade Infantry weapons.");
		System.out.println("It can upgrade Infantry armor.");
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
