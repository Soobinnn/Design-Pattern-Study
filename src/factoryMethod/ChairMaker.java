/*
 * 기능을 수행하는 객체
 * */

package factoryMethod;

public class ChairMaker implements Furniture{

	public ChairMaker() {
		System.out.println("의자메이커 삼삼대기");
	}
	
	@Override
	public void make() {
		System.out.println("의자를 만들었습니다.");
	}
	
	@Override
	public void newDesign() {
		System.out.println("새로운 의자 디자인을 연구합니다.");
		
	}

}
