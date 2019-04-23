package factoryMethod;

public class PizzaStore {

	public static void main(String[] args) {

		PizzaFactory pizzaFactory = new PizzaFactory();
		
		System.out.println("주문 1: 치즈피자");
		pizzaFactory.order("치즈").makePizza();
		
		System.out.println("주문 2: 불고기피자");
		pizzaFactory.order("불고기").makePizza();
		
		System.out.println("주문 3: 쉬림프피자");
		pizzaFactory.order("쉬림프").makePizza();
		
	}

}
