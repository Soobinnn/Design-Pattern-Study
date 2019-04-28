package bridge;

//After Bridge , BigDisplay 구현
public class BigDisplayImp extends DisplayImp{

	
	public BigDisplayImp(String str) {
		super(str);
	}
	@Override
	protected void rawprint() {
		
		System.out.println(str.toUpperCase());
		
	}
}
