package factoryMethod;

public class ShrimpPizza implements Pizza{

	public ShrimpPizza() {
		System.out.println("쉬림프피자 주문 들어옴.");
	}

	@Override
	public void makePizza() {
		System.out.println("쉬림프피자가 만들어졌습니다.");
		
	}

}
