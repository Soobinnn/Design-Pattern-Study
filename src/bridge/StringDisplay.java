package bridge;

//Display 추상 개념을 구현한 문자열을 출력하는 클래스
public class StringDisplay extends Display{
//Before Bridge 패턴
	private String str;
	
	public StringDisplay(String str) {
		this.str=str;
	}
	@Override
	protected void open() {
		printStar();
		
	}

	@Override
	protected void print() {
		System.out.println(str);
		
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
	
	//기능확장
	public void count_display(int repeat_num) {
		open();
		for(int i=0;i<repeat_num;i++)
			System.out.println(str);
		close();
		
	}
	
}
