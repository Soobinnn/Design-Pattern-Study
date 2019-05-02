package flyweight;

public class StringExample {

	public static void main(String[] args) {
		String s1 = new String("스트링");
		String s2 = new String("스트링");
		String s3 = "스트링";
		String s4 = "스트링";
		
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		

	}

}
