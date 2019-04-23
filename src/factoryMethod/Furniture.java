/*
 * BedMaker, ChairMaker, DeskMaker들의 상위 클래스
 * 해당 인터페이스를 통해 객체들이 통일된 메소드를 갖게 한다.
 * 
 * */

package factoryMethod;

public interface Furniture {
	
	public void make();
	
	public void newDesign();

}
