package templateMethod;

public class JinRamen extends Ramen{

	@Override
	public void water() {
		System.out.println("물을 550ml에 건더기 스프를 넣고 끓인다.");
		
	}

	@Override
	public void boil() {
		System.out.println("물이 끓으면 분말스프를 넣고 그 다음 면을 넣고 4분간 끓인다.");
		
	}

}
