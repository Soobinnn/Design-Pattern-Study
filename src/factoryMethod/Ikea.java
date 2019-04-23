/*
 * 필요한 객체를 IkeaFactory 객체로부터 받아와 원하는 기능을 수행한다.
 * IkeaFactory 객체 하나만 생성하면 되기 때문에 확장성이나 유지보수 면에서 좋다.
 * 
 * */
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
