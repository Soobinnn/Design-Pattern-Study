package command;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		PlayerInvoker playerInvoker = new PlayerInvoker();
		System.out.print("닉네임을 입력해주세요: ");
		PlayerReceiver player = new PlayerReceiver(input.nextLine());

		while(true) {
			System.out.print("> ");
			String command = input.nextLine();
			if(command.length() > 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			switch(command.charAt(0)) {
			case 'i':
				playerInvoker.sendCommand(new MoveUpCommand(player));
				break;
			case 'k':
				playerInvoker.sendCommand(new MoveDownCommand(player));
				break;
			case 'j':
				playerInvoker.sendCommand(new MoveLeftCommand(player));
				break;
			case 'l':
				playerInvoker.sendCommand(new MoveRightCommand(player));
				break;
			case 'a':
				playerInvoker.sendCommand(new ShotToggleCommand(player));
				break;
			case 'p':
				playerInvoker.sendCommand(new PrintPositionCommand(player));
				break;
			case 'q':
				return;
			default:
				System.out.println("잘못된 키 입력입니다.");
			}
		}
	}
}
