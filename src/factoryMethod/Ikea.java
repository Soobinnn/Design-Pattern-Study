package factoryMethod;

public class Ikea {

	public static void main(String[] args) {
		
		IkeaFactory ikeaFactory = new IkeaFactory();
		
		System.out.println("주문 1: 책상 생성");
		ikeaFactory.order("책상").make();
		
		System.out.println("주문 2: 의자 생성");
		ikeaFactory.order("의자").make();
		
		System.out.println("주문 3: 침대 디자인 연구");
		ikeaFactory.order("침대").newDesign();
		
	}

}
