package singleTon;

public class SingletonTest 
{
	public static void main(String[] args) 
	{
		 EagerInitialization singleton1 =  EagerInitialization.getInstance();
		 EagerInitialization singleton2 =  EagerInitialization.getInstance();
		
		 if(singleton1 == singleton2) 
		 {
	         System.out.println("singleton1과 singleton2는 서로 같습니다.");
	     }else 
	     {
	         System.out.println("singleton1과 singleton2는 서로 다릅니다.");
	     }
	}
}
