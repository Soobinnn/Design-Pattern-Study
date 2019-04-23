package singleTon;
/*
 * [예제3] 클래스인스턴스가 사용되는 시점에 인스턴스를 만드는 singleton pattern
 *  최초 사용시점에만 인스턴스화 시키기 때문에 프로그램이 메모리에 적재되는 시점에 부담이 많이 줄게됨.
 *  하지만 문제는 남아있음.
 *  MultiThread방식이라면, singletonPattern은 안전하지 않음.
 *  즉, 동일 시점에 getInstance() method를 호출하면 인스턴스가 두번 생길 위험이 있음. 
 */
public class LazyInitialization 
{
	private static LazyInitialization instance;
	private LazyInitialization () {}
	
	public static LazyInitialization getInstance () 
	{
		if ( instance == null )
			instance = new LazyInitialization();
		return instance;
	}
	
	public void print () 
	{
		System.out.println("It's print() method in LazyInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
