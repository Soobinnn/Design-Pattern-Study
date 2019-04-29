# 프록시 패턴(Proxy Pattern)

### 작성자
양동화


## 프록시 패턴(Proxy Pattern)이란?
- **구조 패턴** 중 하나로, 일반적으로 프록시는 다른 무언가와 이어지는 인터페이스의 역할을 하는 클래스이다.
- 즉, 프록시는 실제로 액션을 취하는 객체를 대신해서 대리자 역할을 해준다.
- 복합적인 오브젝트들의 다수의 복사본이 존재해야만 하는 상황에서 프록시 패턴은 애플리케이션의 메모리 사용량을 줄이기 위해 플라이웨이트 패턴과 결합된 형태로 나올 수도 있다.

<details>
	<summary>플라이웨이트 패턴이란?</summary>

**구조 패턴** 중 하나로, 동일하거나 유사한 객체들 사이에 가능한 많은 데이터를 서로 공유하여 사용하도록 하여 메모리 사용량을 최소화하는 소프트웨어 디자인 패턴이다.
</details>


## 문제 - 언제 패턴을 사용하는가?
후술할 **사용되는 방법**과 **장점** 부분을 읽어보자.
### 사용되는 방법
#### 1. Virtual Proxy
생성 자원이 많이 드는 작업을 처리할 경우이다. 프록시 클래스에서 자잘한 작업들을 처리하고 리소스가 많이 요구되는 작업들이 필요할 때(ex) 이미지 뷰어)에만 주체 클래스를 사용하도록 구현할 수 있다.
#### 2. Protection Proxy
주체 클래스에 대한 접근을 제어하기 위한 경우이다. 프록시 클래스에서 클라이언트가 주체 클래스에 대한 접근의 허용 여부를 결정하도록 할 수 있다.  
예외상황에 대한 판단을 Protection Proxy에게 넘김으로서 Client는 예외의 발생에 대해서만 관리하면 된다. 클래스 구조의 접근지정자와는 다른 개념의 접근 제어라 할 수 있다는 점에서 의미가 있다.
#### 3. Remote Proxy
프록시 클래스는 로컬에 두고, 주체 클래스는 원격으로 존재하는 경우이다. (ex) Google Docs)  
네트워크 개념의 프록시는 remote proxy 모델에 가깝다.
#### 4. Smart Reference
객체가 액세스할 때 추가적인 동작을 제공한다.  
C++와 같은 낮은 수준의 언어에 대해서 원시 포인터에 대한 안전한 관리를 위해 스마트 포인터를 두고, 실제 주소공간에 대해 이 스마트 포인터를 통해 접근하도록 할 때 smart reference proxy를 사용한다.

### 사용 예시
[참조 횟수 계산 방식](https://ko.wikipedia.org/wiki/%EC%B0%B8%EC%A1%B0_%ED%9A%9F%EC%88%98_%EA%B3%84%EC%82%B0_%EB%B0%A9%EC%8B%9D), [Spring AOP](https://github.com/gracefulife/DesignPattern/tree/master/src/kr/pe/gracefulife/proxy)
<details>
	<summary>Spring AOP란?</summary>

AOP란 관점 지향 프로그래밍으로 기능을 **핵심 비즈니스 기능**과 **공통 기능**으로 구분하고, 공통 기능을 **개발자의 코드 밖**에서 **필요한 시점**에 적용하는 프로그래밍 방법이다.
</details>

### 각 언어에서의 구현 방법
- Java, C, C#에서는 객체에 대한 인터페이스를 생성하고, 프록시와 실제 주체를 이 인터페이스를 확장하여 구현한 뒤, 프록시를 이용하여 동작을 대리 수행한다.
- [Python](https://sourcemaking.com/design_patterns/proxy/python/1)


## 해결방안 - 설계를 구성하는 요소간의 관계(클래스다이어그램)
### 클래스다이어그램
![UML_Proxy](./img/Proxy_pattern_diagram.svg)

### 참여 객체
- Subject: 객체의 기능을 정의하는 인터페이스 형태로 구현하여, Proxy와 RealSubject가 이 Subject의 기능을 확장하도록 한다. 이 존재로 인해, Client는 Proxy의 역할과 RealSubject의 역할의 차이를 의식할 필요가 없다.
- RealSubject: 실제 객체의 기능을 구현한다. RealSubject는 Proxy의 존재를 모른다.
- Proxy: RealSubject의 대표자 객체를 생성하여, 이 대표자 객체를 이용하여 RealSubject의 기능을 수행시킨다.
- Client: Subject에 명시되어 있는 기능들을 요청한다.


## 결과 - 적용해서 얻는 결과
### 장점
- 사이즈가 큰 객체가 로딩되기 전에도 proxy를 통해 참조할 수 있다.(반응성, 성능 향상 효과)
- 실제 객체의 메소드를 숨기고 인터페이스를 통해 노출시킬 수 있어 안전성이 있다.
- 로컬에 있지 않고 떨어져 있는 객체를 사용할 수 있다.
- 원본 객체의 접근에 대해 사전 처리를 할 수 있다.

### 단점
- 객체 생성 시 한 단계를 더 거치게 되므로, 빈번한 객체 생성이 필요한 경우 성능이 저하될 수 있다.
- 프록시 안에서 실제 객체 생성을 위해 thread가 생성되고 동기화가 구현되어야 하는 경우 성능이 저하되고 로직이 난해해질 수 있다.


## 코드 예제
소스는 `example/proxy`에 있다.
간단한 은행 업무 서비스 예제를 만들어보았다. 기능은 계좌 조회(inquery), 입금(deposit), 출금(withdrawal)이 있다. BankService라는 인터페이스를 정의하여 앞서 말한 세 가지 기능을 정의한 뒤, BankServiceImpl에서 핵심 기능을 작성하고, BankServiceProxy에서는 대리자 객체 bankServiceImpl를 만들어 정의해 둔 기능을 시키도록 하였다.  
서비스의 인터페이스는 다음과 같다.

```java
public interface BankService {
	public int inquery();
	public int deposit(int money);
	public int withdrawal(int money) throws Exception;
}
```

진짜 객체인 BankServiceImpl과 대표자 객체를 생성하여 동작을 수행시킬 proxy인 BankServiceProxy를 작성하였다. 앞서 작성한 인터페이스를 implements했기 때문에 정의해둔 기능을 전부 구현해야 한다.

```java
public class BankServiceImpl implements BankService {
	private String username;
	private int balance;

	public BankServiceImpl(String username) {
		this.username = username;
		this.balance = 0;
	}

	// 계좌 조회
	@Override
	public int inquery() {
		return balance;
	}
	// 입금
	@Override
	public int deposit(int money) {
		balance += money;
		return balance;
	}
	// 출금. 실패 시 Exception을 던지도록 하였다.
	@Override
	public int withdrawal(int money) throws Exception {
		if(balance < money) {
			throw new Exception("Not enough balance");
		}
		balance -= money;
		return balance;
	}
}
```

```java
public class BankServiceProxy implements BankService {
	// BankService를 실질적으로 수행할 대리자(대표자) 객체
	private BankServiceImpl bankServiceImpl;
	private int balance;
	
	public BankServiceProxy(String username) {
		bankServiceImpl = new BankServiceImpl(username);
		balance = bankServiceImpl.inquery();
	}

	/*
	 * BankServiceImpl에서 구현한 기능은 대리자 객체를 통해 수행시키도록 하였고,
	 * 각 메소드가 동작할 때 상태 메시지를 콘솔에 출력시키는 기능을 추가하였다.
	 * 
	 * Proxy의 역할은 Client 역할의 요구를 할 수 있는 만큼 처리하고,
	 * 만약 자신만으로 처리할 수 없으면 RealSubject에게 처리를 맡긴다.
	 */
	@Override
	public int inquery() {
		printStatus("Inquery", true);
		return balance;
	}
	@Override
	public int deposit(int money) {
		balance = bankServiceImpl.deposit(money);
		printStatus("Deposit", true);
		return balance;
	}
	@Override
	public int withdrawal(int money) {
		try {
			balance = bankServiceImpl.withdrawal(money);
			printStatus("Withdrawal", true);
		} catch (Exception e) {
			printStatus("Withdrawal", false);
		}
		return balance;
	}
	public void printStatus(String status, boolean success) {
		System.out.printf("* %s %s *\n> %d\n", status, success ? "Success" : "Faliure", balance);
	}
}
```

이들을 실행해 볼 Client 클래스를 작성한다. 사용자는 단순히 서비스를 호출하여 인터페이스에 정의되어 있는 기능들을 수행할 수 있다.

```java
public class Client {

	public static void main(String[] args) throws Exception {
		Scanner command = new Scanner(System.in);

		System.out.print("S I M P L E   B A N K   S E R V I C E\nI(nquery), D(eposit), W(ithdrawal), Q(uit) \n> Enter your name: ");
		BankService bankService = new BankServiceProxy(command.nextLine());
		
		while(true) {
			System.out.print("> ");
			String argument1 = command.nextLine();
			if(argument1.equalsIgnoreCase("I")) {
				bankService.inquery();
			} else if(argument1.equalsIgnoreCase("D")) {
				System.out.print("How much? ");
				bankService.deposit(command.nextInt());
				command.nextLine();
			} else if(argument1.equalsIgnoreCase("W")) {
				System.out.print("How much? ");
				bankService.withdrawal(command.nextInt());
				command.nextLine();
			} else if(argument1.equalsIgnoreCase("Q")) {
				System.out.println("Service Terminated");
				break;
			} else {
				System.out.println("Wrong Command");
			}
		}
	}
}
```

실행 결과는 다음과 같다.

```
S I M P L E   B A N K   S E R V I C E
I(nquery), D(eposit), W(ithdrawal), Q(uit)
> Enter your name: User
> i
* Inquery Success *
> 0
> d
How much? 5000
* Deposit Success *
> 5000
> w
How much? 200
* Withdrawal Success *
> 4800
> w
How much? 5000
* Withdrawal Failure *
> 4800
> q
Service Terminated

```


### 참고문헌
- [위키백과 - 프록시 패턴](https://ko.wikipedia.org/wiki/%ED%94%84%EB%A1%9D%EC%8B%9C_%ED%8C%A8%ED%84%B4)
- [위키백과 - 플라이웨이트 패턴](https://ko.wikipedia.org/wiki/%ED%94%8C%EB%9D%BC%EC%9D%B4%EC%9B%A8%EC%9D%B4%ED%8A%B8_%ED%8C%A8%ED%84%B4)
- [[Design_Pattern] 프록시 패턴(Proxy Pattern)](https://limkydev.tistory.com/79)
- [java proxy pattern (프록시 패턴)](https://blog.seotory.com/post/2017/09/java-proxy-pattern)
- [Proxy 패턴, 그리고 Dynamic Proxy API](http://wiki.sys4u.co.kr/pages/viewpage.action?pageId=7766156)
- [자바 Proxy Pattern(프록시 패턴) 이란](https://m.blog.naver.com/gracefulife/220650929598)
- [프록시 패턴(Proxy Pattern) - 자바 디자인 패턴과 JDK 예제](http://blog.naver.com/PostView.nhn?blogId=2feelus&logNo=220655183083&redirect=Dlog&widgetTypeCall=true)
- [디자인패턴 - 프록시 패턴](https://yaboong.github.io/design-pattern/2018/10/17/proxy-pattern/)
- [Proxy Design Pattern](https://sourcemaking.com/design_patterns/proxy)
- [[Design pattern] Proxy](https://alleysark.tistory.com/190)
- [Spring AOP 스프링이 해줄건데 너가 왜 어려워 해? Spring boot에서 aop logging 사용법 제일 쉽게 알려드립니다!](https://jeong-pro.tistory.com/171)
- [[DesignPattern] 프록시 패턴](https://devbox.tistory.com/entry/DesignPattern-%ED%94%84%EB%A1%9D%EC%8B%9C-%ED%8C%A8%ED%84%B4)
- GoF의 디자인 패턴
