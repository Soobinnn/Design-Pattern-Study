package decorator;

public class GreenTeaCreamFrappuccino implements StarbucksMenu{
	
	public GreenTeaCreamFrappuccino() {
		System.out.println("그린티 프라푸치노를 선택하셨습니다.");
	}

	@Override
	public int cost() {
		System.out.println("그린티 프라푸치노 가격 : 5000");
		return 5000;
	}

}
