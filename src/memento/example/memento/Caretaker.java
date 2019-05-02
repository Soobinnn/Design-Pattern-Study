package memento;

import java.util.Scanner;
import java.util.Stack;

public class Caretaker {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// List 형태로 표현한 예제가 많지만, 여기서는 문서 편집기라는 느낌을 살리기 위해 스택으로 구현하였다.
		Stack<Memento> savedStates = new Stack<>();
		System.out.println("빈 문서를 생성하고, 편집 모드에 들어갑니다.");
		System.out.println("제목 편집(t), 내용 편집(c), 내용 확인(p), 이전으로 되돌리기(u), 프로그램 종료(q)");

		Originator document = new Originator("", "");
		savedStates.push(document.createMemento());
		
		while(true) {
			System.out.print("> ");
			// 간단한 예제이므로 커맨드가 2자 이상일 때의 예외처리는 따로 하지 않음. 첫 자만 본다.
			char command = input.nextLine().charAt(0);

			if(command == 'q') {
				System.out.println("문서 편집 프로그램을 종료합니다.");
				break;
			}
			
			switch(command) {
			case 't':
				System.out.print("수정할 제목을 입력해주세요: ");
				String newTitle = input.nextLine();
				document.setTitle(newTitle);
				savedStates.push(document.createMemento());
				break;
			case 'c':
				System.out.print("수정할 내용을 입력해주세요: ");
				String newContent = input.nextLine();
				document.setContent(newContent);
				savedStates.push(document.createMemento());
				break;
			case 'p':
				System.out.printf("----- 문서 내용입니다. -----\n%s----------------------------\n", savedStates.peek().getState());
				break;
			case 'u':
				System.out.println("직전 편집 상태로 되돌립니다.");
				if(savedStates.size() > 1) {	// 이전 작업 내역이 있을 경우에만 돌릴 수 있음
					document.setMemento(savedStates.pop());
				}
				break;
			default:
					System.out.println("잘못된 명령어입니다.");
			}			
		}
	}
}
