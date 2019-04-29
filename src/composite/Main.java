package composite;

public class Main {
	public static void main(String[] args) {
		Company cafe24 = new Company("Cafe24");
		cafe24.add(new Member("Jae-Seok"));
		System.out.println(cafe24.getMemberTree());

		cafe24.add(new Member("Gi-Woong"));
		cafe24.add(new Member("Dong-Hwa"));
		cafe24.add(new Member("Jae-Guk"));
		cafe24.add(new Member("Soo-Bin"));
		cafe24.add(new Member("Yeon-Hoon"));
		System.out.println(cafe24.getMemberTree());
		
		System.out.println();
		
		Company feelway = new Company("Feelway");
		
		feelway.add(new Member("SooYong"));
		System.out.println(feelway.getMemberTree());
		
		System.out.println();
		
		cafe24.add(feelway);
		System.out.println(cafe24.getMemberTree());
		
		feelway.add(new Member("SungHoon"));
		System.out.println(cafe24.getMemberTree());
		
		
		cafe24.remove(feelway);
		System.out.println(cafe24.getMemberTree());
	}
}
