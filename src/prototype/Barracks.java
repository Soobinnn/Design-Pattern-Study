package prototype;

public class Barracks implements Building {

	@Override
	public void abilityToDo() {
		System.out.println("It can produce marine.");
		System.out.println("It can produce firebat.");
		System.out.println("It can produce medic.");
		System.out.println("It can produce ghost.");
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
