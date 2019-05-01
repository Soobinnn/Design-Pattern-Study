package prototype;

import java.util.HashMap;

public class BuildManager {

	private HashMap buildingList = new HashMap();
	
	public void register(String buildingName, Building building) {
		buildingList.put(buildingName, building);
	}
	
	public Building create(String buildingName) {
		Building b = (Building) buildingList.get(buildingName);
		return b.createClone();
	}
}
