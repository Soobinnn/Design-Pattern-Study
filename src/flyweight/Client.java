package flyweight;

public class Client {

	public static void main(String[] args) {
		//패턴 적용 전
		//각 유닛 객체는 생성 될 때마다 생성이 된다.
		/*
		ZergUnit unit = new Zergling();
		ZergUnit unit2 = new Zergling();
		ZergUnit unit3 = new HydraRisk();
		ZergUnit unit4 = new HydraRisk();
		*/
		
		//패턴 적용 후
		//Zergling 객체 하나 , HydraRisk 객체 하나를만을 생성한다.
		ZergUnit unit = Hatchery.getZergUnit("Zergling");
		ZergUnit unit2 = Hatchery.getZergUnit("Zergling");
		ZergUnit unit3 = Hatchery.getZergUnit("HydraRisk");
		ZergUnit unit4 = Hatchery.getZergUnit("HydraRisk");
	}

}
