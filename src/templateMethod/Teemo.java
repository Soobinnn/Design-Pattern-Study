package templateMethod;

public class Teemo extends TopLiner{

	@Override
	public void skill() {
		System.out.println("실명!");
		
	}

	@Override
	public void ultimateSkill() {
		System.out.println("독버섯!");
	}

}
