package decorator;

public class LowFatMilk extends CoffeeDecorator{
	
	StarbucksMenu starbucksMenu;

	public LowFatMilk(StarbucksMenu starbucksMenu) {
		System.out.println("저지방 우유 +300원 추가");
		this.starbucksMenu = starbucksMenu;
	}

	@Override
	public int cost() {
		return starbucksMenu.cost() + 300;
	}
	
	

}
