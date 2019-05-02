# 커맨드 패턴(Command Pattern)

### 작성자
양동화


## 커맨드 패턴(Command Pattern)이란?
- **행위 패턴** 중 하나로, 요청 자체를 캡슐화하여, 이를 통해 요청이 서로 다른 사용자를 매개변수로 만들고, 요청을 대기시키거나 로깅하며, 되돌릴 수 있는 연산을 지원한다.
- 다른 이름으로는 작동(Action)과 트랜잭션(Transaction)이 있다.
- 커맨드 패턴에는 명령(Command), 수신자(Receiver), 발동자(Invoker), 클라이언트(Client)의 네 개의 용어가 항상 따른다.


## 문제 - 언제 패턴을 사용하는가?
커맨드 패턴은 요청 자체를 객체로 바꿔, 다른 객체처럼 저장되거나 전달될 수 있도록 지원한다. 이 점을 생각하며 읽어보자.
- GUI 구현 시 메뉴나 버튼에 수행할 작업을 일반화시켜 설정하고자 할 때
- 복구(Undo, Redo) 기능을 지원하고자 할 때
- 작업 수행을 요청한 시점과 실제 작업을 수행하는 시점을 달리 하고 싶을 때: 커맨드 패턴은 직접 수행할 작업에 대한 함수를 불러주는 형태가 아니라 작업에 대한 객체를 먼저 생성하고 나중에 작업 수행을 요청하는 형태이므로, 수행할 작업을 큐 등에 쌓아두었다가 작업 수행이 필요한 시점에 수행하는 것이 가능하다.

### 활용
- Java의 API 중 `java.lang.Runnable`과 `javax.swing.Action`가 커맨드 패턴을 사용하고 있다.
- [여러 사용 예시](https://en.wikipedia.org/wiki/Command_pattern#Uses)가 있는데, 여기서는 세 가지의 예만 후술하겠다.
- Networking: 게임에서의 플레이어 동작과 같은, 전체적인 커맨드를 서로 다른 기계에서 실행될 네트워크를 통해 전체 명령 객체를 보낼 수 있다.
- Wizard: 어플리케이션 코드로부터 UI 코드를 분리해내는 자연스러운 방법은 명령 객체를 사용하여 wizard를 구현하는 것이다. 명령 객체는 wizard의 처음으로 보여질 때 생성된다. 각 wizard의 페이지는 명령 객체에 의한 GUI 변경 사항을 저장하므로, 사용자가 진행함에 따라 명령 개체가 채워진다. "Finish" 버튼은 단순히 execute()를 호출하는 것이다. 이렇게 하면, 명령 클래스는 작동하게 될 것이다.
- 작업 큐: 명령 리스트를 작업 큐에 저장 후 스레드는 큐로부터 명령을 하나씩 받아 각 work의 execute()만 수행하면 된다.

### 각 언어에서의 구현 방법
- 명령의 기능들에 대해 정의해둘 때, C++의 경우에는 가상함수(virtual 키워드 사용)로 기능을 정의하고, Java는 인터페이스나 추상 클래스/메소드로 정의한다. Python의 경우 @abstractmethod을 사용한다.
- [참고: Command Pattern 각 언어별 예제](https://sourcemaking.com/design_patterns/command/python/1)


## 해결방안 - 설계를 구성하는 요소간의 관계(클래스다이어그램)
### 클래스다이어그램
![UML_Command](./img/Command_Design_Pattern_Class_Diagram.png)

### 참여자
- Command(명령): 연산 수행에 필요한 인터페이스를 선언한다. (execute())
- ConcreteCommand(명령자): Receiver 객체를 가지고 있으며, Receiver의 메서드를 호출한다. 커맨드 객체는 별도로 Invoker 객체에 전달되어 명령을 발동하게 한다. 다시 설명하자면, Receiver 객체와 액션 간의 연결성을 정의하고, 처리 객체에 정의된 연산을 호출하도록 execute()를 구현한다.
- Receiver(수신자): Command 객체가 Receiver의 메서드를 호출하면, 자신에게 정의된 메서드를 수행한다.
- Invoker(발동자): 명령어에 처리를 요청할 것을 요청한다. 필요에 따라 명령 발동에 대한 기록을 남길 수 있다. 한 Invoker 객체에 다수의 Command 객체가 전달될 수 있다.
- Client: Invoker 객체와 하나 이상의 Command 객체를 보유한다. 어느 시점에서 어떤 명령을 수행할지를 결정하며, 명령을 수행하려면 Client 객체는 Invoker 객체로 Command 객체를 전달한다. 즉, ConcreteCommand 객체를 생성하고 처리 객체로 정의한다.

### 협력 방법
1. Client는 ConcreteCommand 객체를 생성하고 이를 수신자로 지정한다.
2. Invoker 클래스는 ConcreteCommand 객체를 저장한다.
3. Invoker 클래스는 command에 정의된 execute()를 호출하여 요청을 발생시킨다. 명령어가 취소된 상태라면 ConcreteCommand는 이전에 execute() 호출 전 상태의 취소 처리를 위해 저장한다.
4. ConcreteCommand 객체는 요청을 실제 처리할 객체에 정의된 연산을 호출한다.

## 결과 - 적용해서 얻는 결과
### 장점
- 작업 수행을 요청하는 객체와 실제 작업을 수행하는 객체를 분리시켜주므로 시스템의 결합도를 낮출 수 있다.
- Command와 그 하위 클래스는 기존 클래스와 무관하게 확장할 수 있으며, 확장 시 Client는 별 다른 수정 없이 사용할 수 있다.
- Command 패턴에 Composite 패턴을 조합하여 적용할 경우 복잡한 작업을 기본적인 작업들로 구조화 시켜 다룰 수 있다. Composite 패턴을 이용하여 여러 명령어를 구성할 수 있다.
- 새로운 Command 객체를 추가하기 쉽다. 기존 클래스를 변경할 필요 없이 새로운 명령어에 대응하는 클래스만 정의하면 된다.

### 단점
- Receiver의 동작이 추가된다면 그 동작에 대한 클래스를 만들어야 하기 때문에, 다소 많은 잡다한 클래스들이 추가된다.
- 객체의 구성부가 추가될 경우, 추상화를 시킨 부분부터 수정해야 한다.


## 코드 예제
소스는 `example/command`에 있다.

```java
// 명령 수행에 필요한 인터페이스를 선언한다.
public interface Command {
	public void execute();
}
```

플레이어 동작에 대한 기능을 PlayerReceiver에 구현하였다. 여기서 구현한 메서드들을 ConcreteCommand에서 호출하는 방식으로 사용된다.

```java
/*
 * 플레이어 동작
 * 슈팅 게임에 대한 활동(상하좌우 이동, 미사일 발사(On/Off), 현재 위치 확인)을 할 수 있다.
 * 활동 반경은 가로 100(0~99), 세로 200(0~199)이라고 하자. 
 */
public class PlayerReceiver {
	private String nickname;
	private int positionX;
	private int positionY;
	private boolean isShot;
	
	public PlayerReceiver(String nickname) {
		this.nickname = nickname;  
		positionX = 50;
		positionY = 10;
		isShot = false;
	}
	
	// 닉네임 변경
	public void changeNickname(String nickname) {
		this.nickname = nickname;
	}
	
	// 상하좌우 이동
	public void moveUp() {
		positionY = (positionY < 200) ? positionY + 1 : 200;
	}
	public void moveDown() {
		positionY = (positionY > 1) ? positionY - 1 : 1;
	}
	public void moveLeft() {
		positionX = (positionX > 1) ? positionX - 1 : 1;
	}
	public void moveRight() {
		positionX = (positionX < 100) ? positionX + 1 : 100;
	}
	// 현재 위치 확인
	public void printPosition() {
		System.out.printf("현재 %s 님의 위치는 (%d, %d)입니다.\n", nickname, positionX, positionY);
	}
	
	// 미사일 자동 발사 지정
	public void shotToggle() {
		if(!isShot) {
			System.out.println("미사일을 자동으로 발사합니다.");
			isShot = true;
		} else {
			System.out.println("미사일 자동 발사를 중지합니다.");
			isShot = false;
		}
	}
	
}
```

Receiver에서 작성해 둔 동작들을 수행하는 ConcreteClass를 구현한다.

```java
/*
 * 각 명령에 대한 클래스.
 * Receiver 객체를 가지고, Receiver의 메서드를 호출시킨다.
 * Demo할 때 알아보기 쉽도록 toString을 별도로 구현하였다.
 */
class MoveUpCommand implements Command {
	private PlayerReceiver player;
	
	public MoveUpCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveUp();
	}
	
	public String toString() {
		return "Move up";
	}

}

class MoveDownCommand implements Command {
	private PlayerReceiver player;
	
	public MoveDownCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveDown();
	}
	
	public String toString() {
		return "Move down";
	}

}

class MoveLeftCommand implements Command {
	private PlayerReceiver player;
	
	public MoveLeftCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveLeft();
	}
	
	public String toString() {
		return "Move left";
	}

}

class MoveRightCommand implements Command {
	private PlayerReceiver player;
	
	public MoveRightCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveRight();
	}
	
	public String toString() {
		return "Move right";
	}

}

class PrintPositionCommand implements Command {
	private PlayerReceiver player;
	
	public PrintPositionCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.printPosition();
	}
	
	public String toString() {
		return "Print position";
	}

}

class ShotToggleCommand implements Command {
	private PlayerReceiver player;
	
	public ShotToggleCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.shotToggle();
	}
	
	public String toString() {
		return "Shot toggle";
	}

}

```

앞서 만들어 둔 ConcreteCommand를 발동시키는 Invoker이다.

```java
// Client로부터 받은 Command 객체를 이용하여 명령을 수행한다.
// Redo나 Undo 등의 기능도 구현할 수 있다.
public class PlayerInvoker {
	public void sendCommand(Command command) {
		System.out.println("[Command execute]: " + command);
		command.execute();
	}
}
```

사용자의 입력에 따라 Command를 발동시키는 Client이다.
(i: 위로 이동 / k: 아래로 이동 / j: 좌로 이동 / l: 우로 이동 / a: 미사일 자동발사 OnOff / p: 현재 위치 출력 / q: 종료)

```java
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
				playerInvoker.sendCommand(new ShotPressCommand(player));
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
```

실행 결과는 다음과 같다.

```
닉네임을 입력해주세요: 동화
> p
[Command execute]: Print position
현재 동화 님의 위치는 (50, 10)입니다.
> i
[Command execute]: Move up
> i
[Command execute]: Move up
> l
[Command execute]: Move right
> j
[Command execute]: Move left
> k
[Command execute]: Move down
> p
[Command execute]: Print position
현재 동화 님의 위치는 (50, 11)입니다.
> a
[Command execute]: Shot toggle
미사일을 자동으로 발사합니다.
> k
[Command execute]: Move down
> p
[Command execute]: Print position
현재 동화 님의 위치는 (50, 10)입니다.
> a
[Command execute]: Shot toggle
미사일 자동 발사를 중지합니다.
> q

```


### 참고문헌
- [위키백과 - 커맨드 패턴](https://ko.wikipedia.org/wiki/%EC%BB%A4%EB%A7%A8%EB%93%9C_%ED%8C%A8%ED%84%B4)
- [Wikipedia - Command pattern](https://en.wikipedia.org/wiki/Command_pattern)
- [[디자인 패턴] 커맨드 패턴 ( Command Pattern )](https://victorydntmd.tistory.com/295)
- [Command Pattern (커맨드 패턴)](https://yuns-helloworld.tistory.com/entry/Command-Pattern-%EC%BB%A4%EB%A7%A8%EB%93%9C-%ED%8C%A8%ED%84%B4)
- [Command(명령) 패턴](https://kimsunzun.tistory.com/entry/Command%EB%AA%85%EB%A0%B9-%ED%8C%A8%ED%84%B4)
- [[Design Pattern] 커맨드 패턴이란](https://gmlwjd9405.github.io/2018/07/07/command-pattern.html)
- [디자인 패턴 - 5. Command Pattern](https://anywayjhwa.tistory.com/11)
- GoF의 디자인 패턴
- [커맨드(Command) 패턴과 그 구현](https://javacan.tistory.com/entry/6)

