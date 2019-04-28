package bridge;

//After Bridge , ShortDisplay 구현
public class ShortDisplayImp extends DisplayImp{
	
	public ShortDisplayImp(String str) {
		super(str);
	}
	
	@Override
	protected void rawprint() {
		System.out.println(str.toLowerCase());
		
	}

}
