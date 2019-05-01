package prototype;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
		BuildManager buildManager = new BuildManager();
		CommandCenter cc = new CommandCenter();
		Barracks b = new Barracks();
		EngineeringBay eb = new EngineeringBay();
		buildManager.register("CommandCenter", cc);
		buildManager.register("Barracks", b);
		buildManager.register("EngineeringBay", eb);
		
		System.out.println("press 'b' or 'c' or 'e' ");
		System.out.println("if you want program end. press 'q'");
		char c = new Scanner(System.in).next().charAt(0);
		while(true) {
			if ((int)c == 113){
				System.out.println("press 'q'");
				System.out.println("..quit..");
				break;
			}
			else {
				switch((int)c){
					case 98 :
						Building buildingBarracks = buildManager.create("Barracks");
						buildingBarracks.abilityToDo();
						break;
					case 99 :
						Building buildingCommandCenter = buildManager.create("CommandCenter");
						buildingCommandCenter.abilityToDo();
						break;
					case 101 : 
						Building buildingEnginerringBay = buildManager.create("EngineeringBay");
						buildingEnginerringBay.abilityToDo();
						break;
				}
			}
			System.out.println("press 'b' or 'c' or 'e' ");
			System.out.println("if you want program end. press space-bar");
			c = new Scanner(System.in).next().charAt(0);
		}
		
	}
}
