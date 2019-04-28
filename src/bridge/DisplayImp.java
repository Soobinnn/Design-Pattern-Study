package bridge;

//StringDisplay 구현 , After Bridge
public class DisplayImp {

	protected String str;
	
	public DisplayImp(String str) {
		this.str=str;
	}
		//Display의 시작
		protected void rawopen() {
			printStar();
		}
		//Display
		protected void rawprint() {
			System.out.println(str);
		}
		//Display의 끝
		protected void rawclose() {
			printStar();
		}
		//display
		public void rawdisplay() {
			rawopen();
			rawprint();
			rawclose();
		}
		
		private void printStar() {
			for(int i=0; i<str.length();i++) {
				System.out.print("*");
			}
			System.out.println();
		}
}
