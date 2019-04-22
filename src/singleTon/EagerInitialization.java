package singleTon;

public class EagerInitialization {
	
		// private static 로 선언.
		private static EagerInitialization instance = new EagerInitialization();
		// 생성자
		private EagerInitialization () {
			System.out.println( "call EagerInitialization constructor." );
		}
		// 조회 method
		public static EagerInitialization getInstance () {
			return instance;
		}
		
		public void print () {
			System.out.println("It's print() method in EagerInitialization instance.");
			System.out.println("instance hashCode > " + instance.hashCode());
		}
}
