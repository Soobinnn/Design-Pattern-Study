package command;

// Client로부터 받은 Command 객체를 이용하여 명령을 수행한다.
// Redo나 Undo 등의 기능도 구현할 수 있다.
public class PlayerInvoker {
	public void sendCommand(Command command) {
		System.out.println("[Command execute]: " + command);
		command.execute();
	}
}
