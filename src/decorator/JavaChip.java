package decorator;

public class JavaChip extends CoffeeDecorator{
	
	StarbucksMenu starbucksMenu;

	public JavaChip(StarbucksMenu starbucksMenu) {
		System.out.println("자바 칩 +500원 추가");
		this.starbucksMenu = starbucksMenu;
	}

	@Override
	public int cost() {
		return starbucksMenu.cost() + 500;
	}
	
	

}
