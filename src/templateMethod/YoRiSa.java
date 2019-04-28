package templateMethod;

public class YoRiSa {

	public static void main(String[] args) {
		Ramen ramen1 = new JinRamen();
		Ramen ramen2 = new ShinRamen();
		Ramen ramen3 = new SamYangRamen();
		
		System.out.println("진라면 끓이기");
		ramen1.water();
		ramen1.boil();
		ramen1.eat();
		
		System.out.println("");
		System.out.println("신라면 끓이기");
		ramen2.water();
		ramen2.boil();
		ramen2.eat();
		
	}

}
