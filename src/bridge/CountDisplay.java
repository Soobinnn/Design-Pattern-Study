package bridge;

public class CountDisplay extends Display{

	
	
	public CountDisplay(DisplayImp display) {
		super(display);
	}
	
	public void count_display(int repeat_num) {
		display.rawopen();
		for(int i=0;i<repeat_num;i++)
			display.rawprint();
		display.rawclose();
	}
}
