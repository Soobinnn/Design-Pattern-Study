/*
 * 기능을 수행하는 객체
 * */

package factoryMethod;

public class BedMaker implements Furniture{

	public BedMaker() {
		System.out.println("침대메이커 삼삼대기");
	}

	@Override
	public void make() {
		System.out.println("침대를 만들었습니다.");
	}

	@Override
	public void newDesign() {
		System.out.println("새로운 침대 디자인을 연구합니다.");
		
	}

}
