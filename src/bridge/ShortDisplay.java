package bridge;

//모든 문자를 소문자로 출력해주는 class
public class ShortDisplay extends Display{

private String str;
	
	public ShortDisplay(String str) {
		this.str=str;
	}
	@Override
	protected void open() {
		printStar();
		
	}

	@Override
	protected void print() {
		System.out.println(str.toLowerCase());
		
	}

	@Override
	protected void close() {
		printStar();
		
	}
	
	private void printStar() {
		for(int i=0; i<str.length();i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	public void display() {
		open();
		print();
		close();
	}
	
	public void count_display(int repeat_num) {
		// 내용
		
	}
	
	
}
