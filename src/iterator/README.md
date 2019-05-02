# 반복자 패턴(Iterator Pattern)

### 작성자
양동화


## 반복자 패턴(Iterator Pattern)이란?
- **행위 패턴** 중 하나로, 내부 표현부를 노출하지 않고 어떤 집합 객체에 속한 원소들을 순차적으로 접근할 수 있는 방법을 제공한다.
- 커서(cursor)라고도 한다.


## 문제 - 언제 패턴을 사용하는가?
- 집합 객체의 내부 표현 구조를 노출하지 않고도 자신의 원소에 접근할 수 있는 방법을 제공할 때
- 이미 정의한 방법과는 다른 방법으로 순회하고 싶지만, 기존에 정의한 집합 객체의 인터페이스를 부풀리고 싶지 않을 때
- 동일한 집합 객체에 대해서 하나 이상의 순회 방법을 정의할 때

### 사용 예시
- Java의 Iterator


## 해결방안 - 설계를 구성하는 요소간의 관계(클래스다이어그램)
### 클래스다이어그램
![iterator_UMLClassDiagram](./img/iterator.gif)

### 참여 객체
- Aggregate: 집합 객체 클래스에서 구현해야 할 기능을 정의하는 인터페이스이다. Iterator를 생성하는 기능(createIterator())을 정의하여, 이 집합 객체를 상속하는 클래스는 모두 Iterator를 생성하는 기능을 구현해야 한다.
- ConcreteAggregate: 집합 객체 클래스이다. Aggregate에서 정의한 반복자 생성 기능(createIterator())을 구현해야 한다. 이 클래스로부터 반복자 객체(ConcreteIterator)가 생성된다.
- Iterator: 반복자의 기능을 정의하는 인터페이스이다. 제시된 다이어그램에서는 현재 원소를 첫 번째 원소로 초기화하는 기능(first()), 다음 원소를 순회 과정 중의 현재 원소로 지정하는 기능(next()), 순회할 원소가 더 있는지 확인하는 기능(isDone()), 현재 원소를 알아내는 기능(currentItem())의 네 가지 기능을 구현하도록 정의되어 있다.
- ConcreteIterator: 반복자 클래스이다. Iterator에서 정의한 네 가지 기능을 구현해야 한다. 반복자 객체를 통해 집합 객체를 순회하거나 수정할 수 있다.


## 결과 - 적용해서 얻는 결과
### 장점
- (Java Iterator)컬렉션 종류에 관계 없이 일관성있게 프로그래밍 할 수 있다.
- 집합 객체의 다양한 순회 방법을 제공한다. 다른 순회 방법을 지정하고 싶다면, Iterator는 순회 알고리즘을 바꿀 수 있도록 한다.
- Iterator의 순회 인터페이스는 Aggregate 클래스에 정의한 자신과 비슷한 인터페이스들을 없애서 Aggregate 클래스의 인터페이스를 단순화시킬 수 있다.
- 각 Iterator마다 자신의 순회 상태가 있으므로 집합 객체에 따라 하나 이상의 순회 방법을 제공할 수 있다.

### 단점
- 아무래도 직접 참조하는 방법보다는 속도가 떨어질 수 있다.


## 코드 예제
코드는 `example/iterator`에 있다.

설명

```java
code
```

설명

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
- GoF의 디자인 패턴
- [Iterator](https://www.dofactory.com/net/iterator-design-pattern)
- [Java Iterator 개념 및 사용방법](https://farmerkyh.tistory.com/844)
