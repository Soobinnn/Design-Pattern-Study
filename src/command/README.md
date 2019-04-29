# 커맨드 패턴(Command Pattern)

### 작성자
양동화


## 커맨드 패턴(Command Pattern)이란?
- **행위 패턴** 중 하나로, 요청을 객체의 형태로 캡슐화하여 사용자가 보낸 요청을 나중에 이용할 수 있도록 매서드 이름, 매개변수 등 요청에 필요한 정보를 저장 또는 로깅, 취소할 수 있게 하는 패턴이다.
- 커맨드 패턴에는 명령(Command), 수신자(Receiver), 발동자(Invoker), 클라이언트(Client)의 네 개의 용어가 항상 따른다.


## 문제 - 언제 패턴을 사용하는가?
### 사용되는 방법
ㅇㅇㅇ

### 사용 예시
Java의 API 중 `java.lang.Runnable`과 `javax.swing.Action`가 커맨드 패턴을 사용하고 있다.


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
- Command와 그 하위 클래스는 기존 클래스와 무관하게 확장할 수 있으며, 

### 단점
- Command


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
