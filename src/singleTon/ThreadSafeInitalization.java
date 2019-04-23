package singleTon;
/*
 * [예제4] 멀티쓰레드 문제를 해결하기 위한 동기화 singleton 패턴
 * 
 * synchronized를 사용하여 구현해서 thread들이 동시에 접근해서 인스턴스를 생성시키는 위험은 없어짐
 *  수 많은  thread들이 getInstance()메소드를 호출하게되면 높은 cost비용으로 인해 프로그램전반에 성능저하가 일어남. 
 *  
 */
public class ThreadSafeInitalization 
{
	private static ThreadSafeInitalization instance;
	private ThreadSafeInitalization () {}
	
	public static synchronized ThreadSafeInitalization getInstance () 
	{
		if (instance == null)
			instance = new ThreadSafeInitalization();
		return instance;
	}
	
	public void print () 
	{
		System.out.println("It's print() method in ThreadSafeInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
