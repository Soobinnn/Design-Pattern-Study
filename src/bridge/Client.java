package bridge;

public class Client {

	public static void main(String[] args) {
	/*  Before Bridge */
	/*	//기본 문자열 출력 (구현1)
		Display strdisplay = new StringDisplay("NamGiUng");
		strdisplay.display();
		
		
		//소문자 문자열 출력(구현2)
		Display smalldisplay = new ShortDisplay("NamGiUng");
		smalldisplay.display();
		
		//대문자 문자열 출력(구현3)
		Display bigdisplay = new BigDisplay("NamGiUng");
		bigdisplay.display();
		
		//새로운 기능
		strdisplay.count_display(3); */
		
		/* After Bridge */
		
		//기본 문자열 출력(구현1)
		Display display1 = new Display(new DisplayImp("NamGiUng"));
		display1.display();
		
		//소문자 문자열 출력(구현2)
		Display display2 = new Display(new ShortDisplayImp("NamGiUng"));
		display2.display();
		
		//대문자 문자열 출력(구현3)
		Display display3 = new Display(new BigDisplayImp("NamGiUng"));
		display3.display();
		
		//새로운 기능
		CountDisplay new_display = new CountDisplay(new DisplayImp("NamGiUng"));
		new_display.count_display(3);
		
	}

}
