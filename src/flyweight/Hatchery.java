package flyweight;

import java.util.HashMap;
import java.util.Map;

public class Hatchery {

	public static Map<String,ZergUnit> pool = new HashMap<>();
	
	public static ZergUnit getZergUnit(String name) {
		ZergUnit unit = pool.get(name);
		if(unit == null) {
			if(name.equals("Zergling")) {
				unit = new Zergling();
				pool.put(name,unit);
			}
			else if(name.equals("HydraRisk")) {
				unit = new HydraRisk();
				pool.put(name,unit);
			}
			else
				System.out.println("존재하지 않는 유닛입니다.");
			
		}
		return unit;
	}

}
