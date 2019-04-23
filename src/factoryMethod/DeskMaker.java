/*
 * 기능을 수행하는 객체
 * */

package factoryMethod;

public class DeskMaker implements Furniture{

	public DeskMaker() {
		System.out.println("책상메이커 삼삼대기");
	}

	@Override
	public void make() {
		System.out.println("책상을 만들었습니다.");
	}
	
	@Override
	public void newDesign() {
		System.out.println("새로운 책상 디자인을 연구합니다.");
		
	}
}
