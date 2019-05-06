package chainOfResponsibility;

public class Client {

	public static void main(String[] args) {
		
		System.out.println("에러 발생!");
		System.out.println("");
		
		
		//입력 오류로 에러가 발생한 경우
		System.out.println("입력 오류가 발생한 경우");
		Problem problem1 = Problem.next("IO");
		System.out.println("");
		
		//객체에 null값으로 에러가 발생한 경우
		System.out.println("null 값으로 에러가 난 경우");
		Problem problem2 = Problem.next("null");
			

	}

}
