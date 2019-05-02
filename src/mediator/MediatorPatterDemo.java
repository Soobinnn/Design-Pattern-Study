package mediator;


//예제-1
//여러 사용자가 대화방에 메시지를 보낼때 모든 사용자에게 메시지를 표시하는 것은 대화방의 책임임.
public class MediatorPatterDemo 
{
	 public static void main(String[] args) 
	 {
	      User robert = new User("Robert");
	      User john = new User("John");

	      robert.sendMessage("Hi! John!");
	      john.sendMessage("Hello! Robert!");
	 }
}
