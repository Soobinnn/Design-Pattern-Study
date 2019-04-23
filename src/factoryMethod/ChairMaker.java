package factoryMethod;

public class ChairMaker implements Furniture{

	public ChairMaker() {
		System.out.println("의자메이커 삼삼대기");
	}
	
	@Override
	public void make() {
		System.out.println("의자를 만들었습니다.");
	}

}
