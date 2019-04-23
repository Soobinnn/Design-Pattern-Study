# 프록시 패턴(Proxy Pattern)

## 1. 작성자
양동화


## 2. 프록시 패턴(Proxy Pattern)이란?
- _구조 패턴_ 중 하나로, 일반적으로 프록시는 다른 무언가와 이어지는 인터페이스의 역할을 하는 클래스이다.
- 즉, 프록시는 실제로 액션을 취하는 객체를 대신해서 대리자 역할을 해준다.
- 복합적인 오브젝트들의 다수의 복사본이 존재해야만 하는 상황에서 프록시 패턴은 애플리케이션의 메모리 사용량을 줄이기 위해 플라이웨이트 패턴과 결합된 형태로 나올 수도 있다.

<details>
	<summary>플라이웨이트 패턴이란?</summary>

_구조 패턴_ 중 하나로, 동일하거나 유사한 객체들 사이에 가능한 많은 데이터를 서로 공유하여 사용하도록 하여 메모리 사용량을 최소화하는 소프트웨어 디자인 패턴이다.
</details>


## 3. 왜 사용하는가?
### 3.1. 사용되는 방법
- 1. Protection Proxy
> 주체 클래스에 대한 접근을 제어하기 위한 경우이다. 프록시 클래스에서 클라이언트가 주체 클래스에 대한 접근의 허용 여부를 결정하도록 할 수 있다.

- 2. Virtual Proxy
> 생성 자원이 많이 드는 작업을 처리할 경우이다. 프록시 클래스에서 자잘한 작업들을 처리하고 리소스가 많이 요구되는 작업들이 필요할 때에만 주체 클래스를 사용하도록 구현할 수 있다.

- 3. Remote Proxy
- 프록시 클래스는 로컬에 두고, 주체 클래스는 원격으로 존재하는 경우이다. (ex) Google Docs)

- 사용 예시
> ex) [참조 횟수 계산 방식](https://ko.wikipedia.org/wiki/%EC%B0%B8%EC%A1%B0_%ED%9A%9F%EC%88%98_%EA%B3%84%EC%82%B0_%EB%B0%A9%EC%8B%9D), Spring AOP

### 3.2. 각 언어에서의 사용 예시
- Java, C, C#에서는 객체에 대한 인터페이스를 생성하고, 프록시와 실제 주체를 이 인터페이스를 확장하여 구현한 뒤, 프록시를 이용하여 동작을 대리 수행한다.
- [Python](https://sourcemaking.com/design_patterns/proxy/python/1)


## 4. 장단점
### 4.1. 장점
- 사이즈가 큰 객체가 로딩되기 전에도 proxy를 통해 참조할 수 있다.(반응성, 성능 향상 효과)
- 실제 객체의 메소드를 숨기고 인터페이스를 통해 노출시킬 수 있어 안전성이 있다.
- 로컬에 있지 않고 떨어져 있는 객체를 사용할 수 있다.

### 4.2. 단점
- 객체 생성 시 한 단계를 더 거치게 되므로, 빈번한 객체 생성이 필요한 경우 성능이 저하될 수 있다.
- 프록시 안에서 실제 객체 생성을 위해 thread가 생성되고 동기화가 구현되어야 하는 경우 성능이 저하되고 로직이 난해해질 수 있다.

### 5. 구조와 코드 예제
#### 5.1. UML 클래스 다이어그램
![UML_Proxy](./img/Proxy_pattern_diagram.svg)

#### 5.2. 참여 객체
-

#### 5.3. 코드 예제
-


## 6. 참고자료
- [위키백과 - 프록시 패턴](https://ko.wikipedia.org/wiki/%ED%94%84%EB%A1%9D%EC%8B%9C_%ED%8C%A8%ED%84%B4)
- [위키백과 - 플라이웨이트 패턴](https://ko.wikipedia.org/wiki/%ED%94%8C%EB%9D%BC%EC%9D%B4%EC%9B%A8%EC%9D%B4%ED%8A%B8_%ED%8C%A8%ED%84%B4)
- [[Design_Pattern] 프록시 패턴(Proxy Pattern)](https://limkydev.tistory.com/79)
- [java proxy pattern (프록시 패턴)](https://blog.seotory.com/post/2017/09/java-proxy-pattern)
- [Proxy 패턴, 그리고 Dynamic Proxy API](http://wiki.sys4u.co.kr/pages/viewpage.action?pageId=7766156)
- [자바 Proxy Pattern(프록시 패턴) 이란)(https://m.blog.naver.com/gracefulife/220650929598)
- [프록시 패턴(Proxy Pattern) - 자바 디자인 패턴과 JDK 예제](http://blog.naver.com/PostView.nhn?blogId=2feelus&logNo=220655183083&redirect=Dlog&widgetTypeCall=true)
- [디자인패턴 - 프록시 패턴](https://yaboong.github.io/design-pattern/2018/10/17/proxy-pattern/)
