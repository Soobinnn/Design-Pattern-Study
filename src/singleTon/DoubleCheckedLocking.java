package singleTon;

/*
 * [예제5] Thread safe lazy initialization + Double-checked Locking
 *  getInstance()에 synchronized를 사용하는 것이 아니라 첫번째 if문으로 인스턴스의 존재여부를 체크하고,
 *  if문에서 다시 한번 체크할 때 동기화 시켜서 인스턴스를 생성하므로 thread-safe하면서도 처음 생성 이후에
 *  synchonized블럭을 타지 않기 때문에 성능저하를 완화했다
 *  완벽한 방법은 아님.
 *  * volatile를 선언한 것을 쓰레드가 바로 읽을 경우, 쓰기 직전에 모든 변수를 스레드가 볼수 있다.
 * */
public class DoubleCheckedLocking 
{
	 private volatile static DoubleCheckedLocking instance;
	 
	 private DoubleCheckedLocking(){}
	     
	 public static DoubleCheckedLocking getInstance()
	 {       
	     if(instance == null)
	     {
	         synchronized (DoubleCheckedLocking.class) 
	         {
	             if(instance == null)
	            	 instance = new DoubleCheckedLocking();
	         }
	     }
	     
	     return instance;
	 }

}
