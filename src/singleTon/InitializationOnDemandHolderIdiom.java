package singleTon;

/*[예제6] 기존 싱글톤 패턴의 문제를 해결하기 위한 새로운 싱글톤 패턴
* jvm의 class loader의 매커니즘과 class의 load시점음 이용하여 내부 클래스를 생성시킴으로
* thread간의 동기화문제를 해결함.
* lazy initializaition이 가능하며, 모든 java버전과, jvm에서 사용이 가능함.
* 현재 java에서 singleton을 생성시킨다고하면 거의 아래의 방법을 사용한다고 보면됨.
* 
*/
public class InitializationOnDemandHolderIdiom 
{
	private InitializationOnDemandHolderIdiom () {}
	private static class Singleton 
	{
		private static final InitializationOnDemandHolderIdiom instance = new InitializationOnDemandHolderIdiom();
	}
	
	public static InitializationOnDemandHolderIdiom getInstance () 
	{
		System.out.println("create instance");
		return Singleton.instance;
	}
}
