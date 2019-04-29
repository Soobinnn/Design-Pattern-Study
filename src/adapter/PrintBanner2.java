package adapter;

// 인스턴스에 의한 어댑터 (Adapter)
public class PrintBanner2 extends Print2
{
	private Banner banner;
	
	public PrintBanner2(String string)
	{
		this.banner = new Banner(string);
	}
	
	public void printWeak()
	{
		banner.showWithAster();
	}
	public void printStrong()
	{
		banner.showWithAster();
	}
}
