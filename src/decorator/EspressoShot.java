package decorator;

public class EspressoShot extends CoffeeDecorator{
	
	StarbucksMenu starbucksMenu;

	public EspressoShot(StarbucksMenu starbucksMenu) {
		System.out.println("샷 추가 + 1000원 추가");
		this.starbucksMenu = starbucksMenu;
	}

	@Override
	public int cost() {
		return starbucksMenu.cost() + 1000;
		
	}

	
}
