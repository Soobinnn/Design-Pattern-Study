package flyweight;

public class ZergUnit {
	private String name;
	private int mineral;
	private int gas;
	
	public ZergUnit(String name,int mineral,int gas) {
		this.name=name;
		this.mineral=mineral;
		this.gas=gas;
	}

	public String getName() {
		return name;
	}

	public int getMineral() {
		return mineral;
	}

	public int getGas() {
		return gas;
	}
	
	
	
	

}
