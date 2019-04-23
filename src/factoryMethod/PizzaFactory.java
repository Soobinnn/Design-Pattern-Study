package factoryMethod;

public class PizzaFactory {
	
	public Pizza order(String menu) {
		
		if (menu == "치즈") {return new CheesePizza();}
		if (menu == "쉬림프") {return new ShrimpPizza();}
		if (menu == "불고기") {return new BulgogiPizza();}
		
		return null;
	}

}
