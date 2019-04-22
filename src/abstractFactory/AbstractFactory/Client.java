package AbstractFactory;

public class Client {

	public static void main(String[] args) {
		AbstractFactory factory1 = new ConcreteFactory1();
		factory1.createProductA().useProduct();
		factory1.createProductB().useProduct();
		
		AbstractFactory factory2 = new ConcreteFactory2();
		factory2.createProductA().useProduct();
		factory2.createProductB().useProduct();
		
	}

}
