package decorator;

public class Customer {

	public static void main(String[] args) {
		System.out.println("그린티 프라푸치노에 자바칩, 저지방우유, 샷 추가 해주세요.");
		
		StarbucksMenu order = new EspressoShot(new LowFatMilk(new JavaChip(new GreenTeaCreamFrappuccino())));
		
		System.out.println("총 가격은 " + order.cost() + "입니다.");
	}

}
