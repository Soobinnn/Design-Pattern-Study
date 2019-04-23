    
/*
 * Furniture의 하위 클래스 객체들을 생성하는 역할을 수행한다.
 * Ikea와 Furniture을 연결해주는 중간자 역할
 * 
 * */

package factoryMethod;

public class IkeaFactory {
	
	public Furniture order(String type){
		
		if (type == "침대") {return new BedMaker();}
		if (type == "의자") {return new ChairMaker();}
		if (type == "책상") {return new DeskMaker();}
		
		return null;
		
	}

}
