package templateMethod;

public abstract class Ramen {
	
	public abstract void water();
	
	public abstract void boil();
	
	public void eat() {
		System.out.println("맛있게 먹는다.");
	}

}
