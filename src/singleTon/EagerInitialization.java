package singleTon;
/*
 * [예제1] 가장 기본적인 SingleTon Pattern
 * private static을 이용해서 static이 붙은 클래스 변수를 인스턴스화에 상관없이 사용가능하게됨.
 * 
 * 1. 생성자를 private로 명시함.
 *  
 * EagerInitialization();으로 인해 클래스가 load 되는 시점에 인스턴스를 생성시키는데 이마저도 부담스러울 수가 있다. 
 * 또한 이 소스는 EagerInitialization 클래스가 인스턴스화 되는 시점에 어떠한 에러처리도 할 수가 없다.
 */
public class EagerInitialization 
{
		// private static 로 선언.
		private static EagerInitialization instance = new EagerInitialization();
		
		// 생성자
		private EagerInitialization () 
		{
			System.out.println( "call EagerInitialization constructor." );
		}
		// 조회 method
		public static EagerInitialization getInstance () 
		{
			return instance;
		}
		
		public void print () 
		{
			System.out.println("It's print() method in EagerInitialization instance.");
			System.out.println("instance hashCode > " + instance.hashCode());
		}
}
