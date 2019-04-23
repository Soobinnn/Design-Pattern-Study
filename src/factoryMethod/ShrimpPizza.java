package factoryMethod;

public class ShrimpPizza implements Pizza{

	public ShrimpPizza() {
		System.out.println("쉬림프피자 주문하셨습니다.");
	}

	@Override
	public void makePizza() {
		System.out.println("쉬림프피자가 만들어졌습니다.");
		
	}

}
