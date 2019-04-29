# 커맨드 패턴(Command Pattern)

### 작성자
양동화


## 커맨드 패턴(Command Pattern)이란?
- **행위 패턴** 중 하나로, 요청을 객체의 형태로 캡슐화하여 사용자가 보낸 요청을 나중에 이용할 수 있도록 메서드 이름, 매개변수 등 요청에 필요한 정보를 저장 또는 로깅, 취소할 수 있게 하는 패턴이다.
- 커맨드 패턴에는 명령(Command), 수신자(Receiver), 발동자(Invoker), 클라이언트(Client)의 네 개의 용어가 항상 따른다.


## 문제 - 언제 패턴을 사용하는가?
- GUI 구현 시 메뉴나 버튼에 수행할 작업을 일반화시켜 설정하고자 할 때
- 복구(Undo, Redo) 기능을 지원하고자 할 때
- 작업 수행을 요청한 시점과 실제 작업을 수행하는 시점을 달리 하고 싶을 때: 커맨드 패턴은 직접 수행할 작업에 대한 함수를 불러주는 형태가 아니라 작업에 대한 객체를 먼저 생성하고 나중에 작업 수행을 요청하는 형탵이므로, 수행할 작업을 큐 등에 쌓아두었다가 작업 수행이 필요한 시점에 수행하는 것이 가능하다.

### 활용
- Java의 API 중 `java.lang.Runnable`과 `javax.swing.Action`가 커맨드 패턴을 사용하고 있다.
- [여러 사용 예시](https://en.wikipedia.org/wiki/Command_pattern#Uses)가 있는데, 그 중에서 두 가지의 예만 후술하겠다.
- Networking: 게임에서의 플레이어 동작과 같은, 전체적인 커맨드를 서로 다른 기계에서 실행될 네트워크를 통해 전체 명령 객체를 보낼 수 있다.
- Wizard: 어플리케이션 코드로부터 UI 코드를 분리해내는 자연스러운 방법은 명령 객체를 사용하여 wizard를 구현하는 것이다. 명령 객체는 wizard의 처음으로 보여질 때 생성된다. 각 wizard의 페이지는 명령 객체에 의한 GUI 변경 사항을 저장하므로, 사용자가 진행함에 따라 명령 개체가 채워진다. "Finish" 버튼은 단순히 execute()를 호출하는 것이다. 이렇게 하면, 명령 클래스는 작동하게 될 것이다.
- 작업 큐: 명령 리스트를 작업 큐에 저장 후 스레드는 큐로부터 명령을 하나씩 받아 각 work의 execute()만 수행하면 된다.


## 해결방안 - 설계를 구성하는 요소간의 관계(클래스다이어그램)
### 클래스다이어그램
![UML_Proxy](./img/Command_Design_Pattern_Class_Diagram.png)

### 참여 객체
- Command: 구현해야 할 명령들에 대해 정의해둔다.
- ConcreteCommand: 수신자(Receiver) 객체를 가지고 있으며, 수신자의 메서드를 호출한다. 커맨드 객체는 별도로 발동자(Invoker) 객체에 전달되어 명령을 발동하게 한다.
- Receiver: 명령(Command) 객체가 수신자의 메서드를 호출하면, 자신에게 정의된 메서드를 수행한다.
- Invoker: 필요에 따라 명령 발동에 대한 기록을 남길 수 있다. 한 발동자 객체에 다수의 커맨드 객체가 전달될 수 있다.
- Client: 발동자 객체와 하나 이상의 커맨드 객체를 보유한다. 어느 시점에서 어떤 명령을 수행할지를 결정하며, 명령을 수행하려면 클라이언트 객체는 발동자 객체로 커맨드 객체를 전달한다.


## 결과 - 적용해서 얻는 결과
### 장점
- 작업 수행을 요청하는 객체와 실제 작업을 수행하는 객체를 분리시켜주므로 시스템의 결합도를 낮출 수 있다.
- Command와 그 하위 클래스는 기존 클래스와 무관하게 확장할 수 있으며, 확장 시 Client는 별 다른 수정 없이 사용할 수 있다.
- Command 패턴에 Composite 패턴을 조합하여 적용할 경우 복잡한 작업을 기본적인 작업들로 구조화 시켜 다룰 수 있다.

### 단점
- Receiver의 동작이 추가된다면 그 동작에 대한 클래스를 만들어야 하기 때문에, 다소 많은 잡다한 클래스들이 추가된다.
- 객체의 구성부가 추가될 경우, 추상화를 시킨 부분부터 수정해야 한다.


## 코드 예제
소스는 `example/command`에 있다.
설명

```java
code
```

설명

```java
code
```

```java
code
```

설명

```java
code
```

실행 결과는 다음과 같다.

```
결과
```


### 참고문헌
- [위키백과 - 커맨드 패턴](https://ko.wikipedia.org/wiki/%EC%BB%A4%EB%A7%A8%EB%93%9C_%ED%8C%A8%ED%84%B4)
- [Wikipedia - Command pattern](https://en.wikipedia.org/wiki/Command_pattern)
- [[디자인 패턴] 커맨드 패턴 ( Command Pattern )](https://victorydntmd.tistory.com/295)
- [Command Pattern (커맨드 패턴)](https://yuns-helloworld.tistory.com/entry/Command-Pattern-%EC%BB%A4%EB%A7%A8%EB%93%9C-%ED%8C%A8%ED%84%B4)
- [Command(명령) 패턴](https://kimsunzun.tistory.com/entry/Command%EB%AA%85%EB%A0%B9-%ED%8C%A8%ED%84%B4)
- [[Design Pattern] 커맨드 패턴이란](https://gmlwjd9405.github.io/2018/07/07/command-pattern.html)
- [디자인 패턴 - 5. Command Pattern](https://anywayjhwa.tistory.com/11)
