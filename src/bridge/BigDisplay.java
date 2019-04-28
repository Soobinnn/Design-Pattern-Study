package bridge;

public class BigDisplay extends Display{
	
	private String str;
		
		public BigDisplay(String str) {
			this.str=str;
		}
		@Override
		protected void open() {
			printStar();
			
		}

		@Override
		protected void print() {
			
			System.out.println(str.toUpperCase());
			
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


