package state;

public class Client {

	public static void main(String[] args) {
		// 패턴 적용 전
		/*Git gitbash = new Git();
		gitbash.Do();
		gitbash.Do();
		gitbash.Do();
		gitbash.Do();
		*/

		//패턴 적용 후
		Git gitbash = new NewStatus();
		gitbash=gitbash.Do();
		gitbash=gitbash.Do();
		gitbash=gitbash.Do();
		gitbash=gitbash.Do();
		
	}

}
