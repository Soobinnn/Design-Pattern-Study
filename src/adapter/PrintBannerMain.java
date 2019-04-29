package adapter;

//클래스에 의한 어댑터 패턴 (Client)
public class PrintBannerMain 
{
	public static void main(String[] args) 
	{
		Print p = new PrintBanner("Hello");
		p.printWeak();
		p.printStrong();
	}
}
