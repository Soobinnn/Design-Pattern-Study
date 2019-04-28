package bridge;
//Before Bridge 패턴
/*public abstract class Display {

	
	//Display의 시작
	protected abstract void open();
	//Display
	protected abstract void print();
	//Display의 끝
	protected abstract void close();
	//display
	public abstract void display();
	
	//if 기능추가 then 새로운 메소드 정의
	public abstract void count_display(int repeat_num);
}*/

//After Bridge 패턴
public class Display{
	
	protected DisplayImp display;
	
	public Display(DisplayImp display) {
		this.display=display;
	}
	
	//display
	public void display() {
		display.rawdisplay();
	}

}