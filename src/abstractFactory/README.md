# 추상 팩토리 패턴(Abstract Factory Pattern)

### 작성자
양동화


## 추상 팩토리 패턴(Abstract Factory Pattern)이란?
- **생성 패턴** 중 하나로, 다양한 구성 요소 별로 '객체의 집합'을 생성해야 할 때 유용하다.
- 팩토리 메서드 패턴을 조금 더 캡슐화한 방식이라고 볼 수 있는데, 두 패턴의 차이가 명확하기 때문에 엄연히 사용해야 할 상황이 다르다.
- 객체의 생성과 조합을 캡슐화해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공한다.


## 문제 - 언제 패턴을 사용하는가?
팩토리 메서드 패턴의 경우 각 구성품마다 팩토리를 만들어서 객체를 형성하는 반면, 추상 팩토리 패턴은 어떤 객체의 구성품이 일정한 경우 관련된 객체들을 한꺼번에 캡슐화하여 팩토리로 만들어서 일관되게 객체를 생성하도록 할 때 사용한다.  
두 패턴의 차이점에 대한 예제는 이 [문서](https://victorydntmd.tistory.com/300)를 참고하자.

### 사용 예시
- 어떤 라이브러리를 배포하는 데 OS별로 지원하는 기능이 상이할 때
- Java GUI 구성 요소인 AWT/Swing 라이브러리의 룩 앤드 필(소프트웨어 디자인에서 룩 앤드 필은 그래픽 사용자 인터페이스의 관점에서 쓰이는 개념으로, 스타일뿐 아니라 동작을 수반하는 디자인의 측면을 이루고 있다.) 변경 기능 - 메탈, 마이크로소프트 윈도, 맥 OS 등의 모양으로 각각 변경 가능

### 각 언어에서의 구현 방법
> **해결방안** 항목을 먼저 읽은 후에 다시 읽어보는 것을 추천한다.

- C#, Java, Golang에서는 추상적으로 표현해야 하는 부분은 interface로 구현한다.
- Java에서는 interface 대신 추상 클래스(abstract class)를 사용하여 선언하고, 인자값으로 어떤 Factory를 사용할 지 제어할 수 있다. Java의 interface와 추상 클래스의 차이는 이 [문서](https://brunch.co.kr/@kd4/6)를 참고하자.
- Python의 경우 interface가 따로 존재하지 않으므로 추상적으로 명시해두는 요소들의 기능들을 `@abstractmethod`를 선언하여 구현한다. Java에서 추상 클래스를 사용하여 구현하는 방법과 유사하다.


## 해결방안 - 설계를 구성하는 요소간의 관계 (클래스다이어그램)
### 클래스다이어그램
![Class Diagram](./img/Abstract_factory_UML.svg)
### 참여 객체
- AbstractFactory: 개념적 제품에 대한 객체를 생성하는 오퍼레이션으로 인터페이스를 정의한다.
- ConcreteFactory: 구체적인 제품에 대한 객체를 생성하는 오퍼레이션을 구성한다.
- AbstractProduct: 개념적 제품 객체에 대한 인터페이스를 정의한다.
- ConcreteProduct: 구체적으로 팩토리가 생성할 객체를 정의하고, AbstractProduct가 정의하고 있는 인터페이스를 구현한다.
- Client: AbstractFactory와 AbstractProduct 클래스에 선언된 인터페이스를 사용한다.


## 결과 - 적용해서 얻는 결과
### 장점
- 확장에 매우 용이한 패턴으로 쉽게 다른 서브 클래스들을 확장할 수 있다.
- 기존 팩토리 패턴의 if-else 로직에서 벗어날 수 있게 해준다.
- 구체적인 클래스를 분리하여 제품군을 쉽게 대체할 수 있도록 한다.
- 제품 사이의 일관성을 증진시킨다.

### 단점
- 새로운 종류의 제품을 제공하기 힘들다.
   - 다양한 제품군은 제공할 수 있지만, 기존 제품에 새로운 기능을 추가하는 경우 모든 팩토리에 새로운 기능을 추가해야 하는 문제가 발생한다. 이는 재사용성을 해치는 단점으로 작용할 수 있다.


## 코드 예제
**클래스다이어그램**에 명시되어 있는 모델을 참고하여 Java 코드를 작성해보았다. `ProductA1, ProductA2, ProductB1, ProductB2`는 **6.2. 참여 객체**에 명시된 대로 표현하기 위해 각각의 이름 앞에 `Concrete`를 붙여서 표현하였다.
> 소스는 example/abstractFactory에 있다.

ProductA와 ProductB를 생성하는 기능을 가진 Factory의 인터페이스를 정의하고, 아무런 기능도 넣진 않았지만 ProductA와 ProductB의 인터페이스도 정의한다.

```java
// ProductA와 ProductB를 생성하는 Factory 객체에 대한 인터페이스 정의
public interface AbstractFactory {
	public ProductA createProductA();
	public ProductB createProductB();
}
```

```java
public interface ProductA {
}
```

```java
public interface ProductB {
}
```
AbstractFactory에서 정의해 둔 기능을 구현한 ConcreteFactory1과 ConcreteFactory2를 작성하고, ProductA에서 정의해 둔 기능을 구현한 ProductA1, ProductA2와, ProductB에서 정의해 둔 기능을 구현한 ProductB1, ProductB2를 작성한다.  
Factory1에서는 ProductA1과 ProductB1 객체를, Factory2에서는 ProductA2과 ProductB2 객체를 생성하도록 작성한다.

```java
public class ConcreteFactory1 implements AbstractFactory {
	@Override
	public ProductA createProductA() {
		return new ProductA1();
	}
	@Override
	public ProductB createProductB() {
		return new ProductB1();
	}
}
```

```java
public class ConcreteFactory2 implements AbstractFactory {
	@Override
	public ProductA createProductA() {
		return new ProductA2();
	}
	@Override
	public ProductB createProductB() {
		return new ProductB2();
	}
}
```

```java
public class ProductA1 implements ProductA {
	public ProductA1() {
		System.out.println("Product A1 is created");
	}
}
```

```java
public class ProductA2 implements ProductA {
	public ProductA2() {
		System.out.println("Product A2 is created");
	}
}
```

```java
public class ProductB1 implements ProductB {
	public ProductB1() {
		System.out.println("Product B1 is created");
	}
}
```

```java
public class ProductB2 implements ProductB {
	public ProductB2() {
		System.out.println("Product B2 is created");
	}
}
```

테스트를 해볼 Client 클래스를 작성한다. 각각 Factory1과 Factory2 객체를 생성한 다음, 그 각각의 객체에서 Product가 의도한 대로 생성되는지 확인해보자.

```java
public class Client {
	public static void main(String[] args) {
		AbstractFactory factory1 = new ConcreteFactory1();
		factory1.createProductA();
		factory1.createProductB();
		
		AbstractFactory factory2 = new ConcreteFactory2();
		factory2.createProductA();
		factory2.createProductB();
	}
}
```

출력 결과는 다음과 같다. Factory1에서는 ProductA1와 ProductB1이 생성되고, Factory2에서는 ProductA2와 ProductB2가 생성됨을 확인할 수 있다.

```
Product A1 is created
Product B1 is created
Product A2 is created
Product B2 is created
```


### 참고문헌
- [(개발상식) 13.UML이란?](https://asfirstalways.tistory.com/95)
- [위키백과 - 통합 모델링 언어](https://ko.wikipedia.org/wiki/%ED%86%B5%ED%95%A9_%EB%AA%A8%EB%8D%B8%EB%A7%81_%EC%96%B8%EC%96%B4)
- [(디자인패턴) 생성패턴, 구조패턴, 행위패턴](https://blog.naver.com/PostView.nhn?blogId=jvioonpe&logNo=220227413391&proxyReferer=https%3A%2F%2Fwww.google.com%2F)
- [위키백과 - 추상 팩토리 패턴](https://ko.wikipedia.org/wiki/%EC%B6%94%EC%83%81_%ED%8C%A9%ED%86%A0%EB%A6%AC_%ED%8C%A8%ED%84%B4)
- GoF의 디자인 패턴
- [추상 팩토리 패턴(Abstract Factory Pattern](https://jdm.kr/blog/192)
- [java abstract factory pattern(추상 팩토리 패턴)](https://blog.seotory.com/post/2016/08/java-abstract-factory-pattern)
- [팩토리 패턴](https://boomsprogramming.tistory.com/entry/팩토리-패턴factory-pattern)
- [디자인 패턴 - 추상 팩토리(Abstract Factory)](https://yukariko.github.io/designpattern/2016/08/19/abstract-factory.html)
- [(Design Pattern) 추상 팩토리 패턴이란](https://gmlwjd9405.github.io/2018/08/08/abstract-factory-pattern.html)
- [(디자인 패턴) 추상 팩토리 패턴 ( Abstract Factory Pattern )](https://victorydntmd.tistory.com/300)
- [Abstract Factory in Python](https://sourcemaking.com/design_patterns/abstract_factory/python/1)
- [Wikipedia - Abstract factory pattern](https://en.wikipedia.org/wiki/Abstract_factory_pattern)
