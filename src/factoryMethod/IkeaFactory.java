package factoryMethod;

public class IkeaFactory {
	
	public Furniture order(String type){
		
		if (type == "침대") {return new BedMaker();}
		if (type == "의자") {return new ChairMaker();}
		if (type == "책상") {return new DeskMaker();}
		
		return null;
		
	}

}
