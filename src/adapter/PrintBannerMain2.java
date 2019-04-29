package adapter;

// 인스턴스에 의한 어댑터 패턴(Client)
public class PrintBannerMain2 
{
	public static void main(String[] args) 
	{
		Print2 p = new PrintBanner2("Hello");
		p.printWeak();
		p.printStrong();
	}
}
