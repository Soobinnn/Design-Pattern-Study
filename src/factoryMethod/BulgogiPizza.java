package factoryMethod;

public class BulgogiPizza implements Pizza{

	public BulgogiPizza() {
		System.out.println("불고기피자 주문하셨습니다.");
	}

	@Override
	public void makePizza() {
		System.out.println("불고기피자가 만들어졌습니다.");
		
	}

}
