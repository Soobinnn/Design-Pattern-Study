package adapter;

//클래스에 의한 어댑터 패턴 (Adapter)
public class PrintBanner extends Banner implements Print
{
	public PrintBanner(String string)
	{
		super(string);
	}
	
	public void printWeak()
	{
		showWithParen();
	}
	
	public void printStrong()
	{
		showWithAster();
	}
}
