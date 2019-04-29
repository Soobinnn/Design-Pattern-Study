package composite;

public class Member extends Social{
	private String name;
	public Member(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

}
