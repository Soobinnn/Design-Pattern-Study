# 메멘토 패턴(Memento Pattern)

### 작성자
양동화


## 메멘토 패턴(Memento Pattern)이란?
- **행위 패턴** 중 하나로, 캡슐화를 위배하지 않은 채 어떤 객체의 내부 상태를 잡아내고 실체화시켜 둠으로써, 이후 해당 객체가 그 상태로 되돌아올 수 있도록 하는 소프트웨어 디자인 패턴이다.
- 롤백을 통한 실행 취소를 예로 들 수 있다.
- Memento, Originator, Caretaker의 3개의 객체로 구현된다. 


## 문제 - 언제 패턴을 사용하는가?

### 사용 예시

### 각 언어에서의 구현 방법
- Java, C, C#에서는 객체에 대한 인터페이스를 생성하고, 프록시와 실제 주체를 이 인터페이스를 확장하여 구현한 뒤, 프록시를 이용하여 동작을 대리 수행한다.
- [Python](https://sourcemaking.com/design_patterns/proxy/python/1)


## 해결방안 - 설계를 구성하는 요소간의 관계(클래스다이어그램)
### 클래스다이어그램
![UML_Proxy](./img/W3sDesign_Memento_Design_Pattern_UML.jpg)

### 참여 객체
- Memento: 원조본 객체의 내부 상태를 저장한다. 원조본 객체의 내부 상태를 필요한 만큼 저장해 두고, 원조본 객체를 제외한 다른 객체는 자신에게 접근할 수 없도록 막는다.
- Originator: 원조본 객체를 말한다. 메멘토를 생성하여 현재 객체의 상태를 저장하고 메멘토를 사용하여 내부 상태를 복원한다.
- Caretaker: 메멘토의 보관을 책임지는 보관자를 말한다. 메멘토의 내용을 검사하거나 메멘토의 내용을 건드리지는 않는다.


## 결과 - 적용해서 얻는 결과
### 장점

### 단점


## 코드 예제
소스는 `example/proxy`에 있다.
간단한 은행 업무 서비스 예제를 만들어보았다. 기능은 계좌 조회(inquery), 입금(deposit), 출금(withdrawal)이 있다. BankService라는 인터페이스를 정의하여 앞서 말한 세 가지 기능을 정의한 뒤, BankServiceImpl에서 핵심 기능을 작성하고, BankServiceProxy에서는 대리자 객체 bankServiceImpl를 만들어 정의해 둔 기능을 시키면서, BankService에서 throw한 Exception을 상황에 맞게 처리하는 추가적인 기능도 구현해 보았다.  
서비스의 인터페이스는 다음과 같다.

```java
```

진짜 객체인 BankServiceImpl과 대표자 객체를 생성하여 동작을 수행시킬 proxy인 BankServiceProxy를 작성하였다. 앞서 작성한 인터페이스를 implements했기 때문에 정의해둔 기능을 전부 구현해야 한다.

```java
```

```java
```

```java
```

실행 결과는 다음과 같다.

```
```


### 참고문헌
- GoF의 디자인 패턴
- [위키백과 - 메멘토 패턴](https://ko.wikipedia.org/wiki/%EB%A9%94%EB%A9%98%ED%86%A0_%ED%8C%A8%ED%84%B4)
