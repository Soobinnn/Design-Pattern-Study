package factoryMethod;

public class CheesePizza implements Pizza{

	public CheesePizza() {
		System.out.println("치즈피자 주문하셨습니다.");
	}

	@Override
	public void makePizza() {
		System.out.println("치즈피자가 만들어졌습니다.");
		
	}

}
