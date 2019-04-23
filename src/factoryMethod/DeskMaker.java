package factoryMethod;

public class DeskMaker implements Furniture{

	public DeskMaker() {
		System.out.println("책상메이커 삼삼대기");
	}

	@Override
	public void make() {
		System.out.println("책상을 만들었습니다.");
	}
}
