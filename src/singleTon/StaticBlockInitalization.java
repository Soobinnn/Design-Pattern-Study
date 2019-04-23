package singleTon;
/*
 * [예제2] static 초기화 블럭을 이용한 sigleTon
 * 초기화블럭을 이용하면 logic을 담을 수 있기 때문에 복잡한 초기변수 세팅, 에러처리를 위한 구문을 담을 수 있음.
 * [예제1]보다 좋아보이지만, 인스턴스가 사용되는 시점에 생성되는 것은 아님.
 */
public class StaticBlockInitalization 
{
	private static StaticBlockInitalization instance;
	private StaticBlockInitalization () {}
	
	static 
	{
		try 
		{
			System.out.println("instance create..");
			instance = new StaticBlockInitalization();
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Exception creating StaticBlockInitalization instance.");
		}
	}
	
	public static StaticBlockInitalization getInstance () 
	{
		return instance;
	}
	
	public void print () 
	{
		System.out.println("It's print() method in StaticBlockInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
