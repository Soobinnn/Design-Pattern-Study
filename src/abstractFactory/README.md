# 추상 팩토리 패턴(Abstract Factory Pattern)

## 작성자
양동화


## 들어가기 전에
### 패턴의 분류
> 디자인 패턴은 목적에 따라 '생성', '구조', '행위'패턴으로 나눌 수 있고, 범위에 따라 클래스를 대상으로 하느냐, 객체를 대상으로 하느냐로 나눌 수 있다.

1. 생성 패턴(Creational patterns)
2. 구조 패턴(Structural patterns)
3. 행위 패턴(Behavioral patterns)

### UML(Unified Modeling Language)란?
#### 정의
> 프로그램 설계를 표현하기 위해 주로 사용하는, 주로 그림으로 된 표기법을 의미한다. 프로그래밍 언어나 방법론이 나닌, 모델링 언어이다.

#### 사용하는 이유
> 객체 지향 소프트웨어 집약 시스템을 개발할 때 산출물을 명세화, 시각화, 문서화할 때 사용한다.


## 추상 팩토리 패턴이란?
- 구체적인 클래스를 지정하지 않고 관련성을 갖는 객체들의 집합을 생성하거나 서로 독립적인 객체들의 집합을 생성할 수 있는 인터페이스를 제공한다.
- 생성 패턴에 해당한다.
   - 객체 생성에 관련된 패턴
   - 객체의 생성과 조합을 캡슐화해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공한다.

### 특징
- 다양한 구성 요소 별로 '객체의 집합'을 생성해야 할 때 유용하다. 이 패턴을 사용하여 상황에 알맞은 객체를 생성할 수 있다.
- 많은 수의 연관된 서브 클래스를 특정 그룹으로 묶어 한번에 교체할 수 있도록 만든 디자인 패턴을 말한다.
- 오버라이딩 기법을 사용한다.
- 다양한 구성 요소별로 '객체의 집합'을 생성해야 할 때 유용하다.

### 사용 예시
- 어떤 라이브러리를 배포하는 데 OS별로 지원하는 기능이 상이할 때
- Java GUI 구성 요소인 AWT/Swing 라이브러리의 룩 앤드 필(소프트웨어 디자인에서 룩 앤드 필은 그래픽 사용자 인터페이스의 관점에서 쓰이는 개념으로, 스타일뿐 아니라 동작을 수반하는 디자인의 측면을 이루고 있다.) 변경 기능 - 메탈, 마이크로소프트 윈도, 맥 OS 등의 모양으로 각각 변경 가능

### 구조와 참여 객체
#### 구조
[구조](https://ko.wikipedia.org/wiki/추상_팩토리_패턴#/media/File:Abstract_factory_UML.svg)
#### 참여 객체
- AbstractFactory: 개념적 제품에 대한 객체를 생성하는 오퍼레이션으로 인터페이스를 정의한다.
- ConcreteFactory: 구체적인 제품에 대한 객체를 생성하는 오퍼레이션을 구성한다.
- AbstractProduct: 개념적 제품 객체에 대한 인터페이스를 정의한다.
- ConcreteProduct: 구체적으로 팩토리가 생성할 객체를 정의하고, AbstractProduct가 정의하고 있는 인터페이스를 구현한다.
- Client: AbstractFactory와 AbstractProduct 클래스에 선언된 인터페이스를 사용한다.

### 장점
- 인터페이스보다는 구조체에 접근할 수 있는 코드를 제공한다.
- 확장에 매우 용이한 패턴으로 쉽게 다른 서브 클래스들을 확장할 수 있다.
- 기존 팩토리 패턴의 if-else 로직에서 벗어날 수 있게 해준다.
- 구체적인 클래스를 분리한다.
- 제품군을 쉽게 대체할 수 있도록 한다.
- 제품 사이의 일관성을 증진시킨다.

### 단점
- 새로운 종류의 제품을 제공하기 힘들다.
   - 재사용성을 해치는 단점으로 작용할 수 있다.

### Java 예제
AbstractFactory 패키지에 작성해놓았다.
#### UML 클래스 다이어그램
[참고](https://ko.wikipedia.org/wiki/추상_팩토리_패턴#/media/File:Abstract_factory_UML.svg)


## 참고자료
- [(디자인패턴) 생성패턴, 구조패턴, 행위패턴](https://blog.naver.com/PostView.nhn?blogId=jvioonpe&logNo=220227413391&proxyReferer=https%3A%2F%2Fwww.google.com%2F)
- [위키백과 - 추상 팩토리 패턴](https://ko.wikipedia.org/wiki/%EC%B6%94%EC%83%81_%ED%8C%A9%ED%86%A0%EB%A6%AC_%ED%8C%A8%ED%84%B4)
- GoF의 디자인 패턴
- [(개발상식) 13.UML이란?](https://asfirstalways.tistory.com/95)
- [위키백과 - 통합 모델링 언어](https://ko.wikipedia.org/wiki/%ED%86%B5%ED%95%A9_%EB%AA%A8%EB%8D%B8%EB%A7%81_%EC%96%B8%EC%96%B4)
- [추상 팩토리 패턴(Abstract Factory Pattern](https://jdm.kr/blog/192)
- [java abstract factory pattern(추상 팩토리 패턴)](https://blog.seotory.com/post/2016/08/java-abstract-factory-pattern)
- [팩토리 패턴](https://boomsprogramming.tistory.com/entry/팩토리-패턴factory-pattern)
- [디자인 패턴 - 추상 팩토리(Abstract Factory)](https://yukariko.github.io/designpattern/2016/08/19/abstract-factory.html)
- [(Design Pattern) 추상 팩토리 패턴이란](https://gmlwjd9405.github.io/2018/08/08/abstract-factory-pattern.html)
