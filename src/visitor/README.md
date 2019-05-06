# 비지터 패턴 (Visitor pattern)

#### 유재국

## 비지터 패턴(Visitor pattern)이란?

객체에서 구조와 기능을 분리시켜주는 패턴

## 문제 - 언제 패턴을 사용하는가?

기존의 클래스 설계 이후 새로운 기능을 추가해야할 경우, 기존의 코드를 수정하지 않고 사용하려 할 때(새로운 기능 변경이 주 된 목적. 알고리즘 변경이 주 된 목적일 때)

## 해결방안 - 설계를 구성하는 요소 간의 관계 (클래스 다이어그램)
![](https://github.com/Soobinnn/Design-Pattern-Study/blob/master/src/visitor/W3sDesign_Visitor_Design_Pattern_UML.jpg)

## 결과 - 적용해서 얻는 결과

한 클래스 내에 있는 구조와 기능을 각각 다른 클래스로 분리시켜 서로 호출하여 사용하도록 함으로 새로운 기능을 추가할 때 구조를 수정하지 않고도 실질적으로 새로운 동작을 기존의 객체 구조에 추가할 수 있다.

## - 장점

처리를 데이터 구조에서 분리시켜주기 때문에 코드 유지보수가 용이

데이터와 기능을 분리해서 구현함으로 데이터의 독립성을 높여줌

## - 단점

작업 데이터의 추가, 확장의 어려움. 작업 대상의 데이터를 추가해야할 경우. 인터페이스를 수정해야 하며 그에 관련된 하위 클래스(기능 구현 코드)에도 새로운 멤버를 추가해야 하기 때문기능 구현을 맡은 객체가 데이터 객체를 참조하는 구조이기 때문에, 클래스간에 결합도가 증가되는 문제

## 코드 예제 및 다이어그램 
![](https://github.com/Soobinnn/Design-Pattern-Study/blob/master/src/visitor/visitor%20pattern%20%E1%84%8B%E1%85%A8%E1%84%8C%E1%85%A6%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A8%E1%84%83%E1%85%A9%201.png)
![](https://github.com/Soobinnn/Design-Pattern-Study/blob/master/src/visitor/visitor%20pattern%20%E1%84%8B%E1%85%A8%E1%84%8C%E1%85%A6%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A8%E1%84%83%E1%85%A9%202.png)

```java

interface CarElement {
	void accept(CarElementVisitor visitor); 
}
// CarElement 인터페이스는 요소를 정의하는 역할

class Car implements CarElement{
    CarElement[] elements;
    public CarElement[] getElements() {
        return elements.clone(); // Return a copy of the array of references.
    }
    public Car() {
        this.elements = new CarElement[]
          { new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left") , new Wheel("back right"),
            new Body(), new Engine() };
    }
    public void accept(CarElementVisitor visitor) {
        for(CarElement element : this.getElements()) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}
// Car 클래스는 CarElement 인터페이스를 확장하여 무인 생성자에서 여러 클래스를 통해 자신을 생성하고 accept함수에서 visitor에게 자신을 구성하는 클래스(데이터)를 리턴해주고 visitor의 기능을 수행한다.


class Wheel implements CarElement {
    private String name;
    public Wheel(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
// Wheel 클래스는 CarElement 인터페이스를 확장하여 휠의 이름을 뜻하는 name 데이터를 갖고 있고, accept함수에서 visitor의 visit 기능을 수행하는 역하을 하도록 했다.


class Body implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
// Body 클래스는 CarElement 인터페이스를 확장하여 따로 데이터는 생성하지 않았고, accept함수에서 visitor의 visit 기능을 수행하는 역할을 하도록 했다.


class Engine implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
// Engine 클래스는 CarElement 인터페이스를 확장하여 따로 데이터는 생성하지 않았고, accept함수에서 visitor에 visitor의 기능을 수행하는 역할을 하도록 했다.


interface CarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);
}
// CarElementVisitor 인터페이스는 어떤 데이터에 visit 할 것인지 정의

class CarElementPrintVisitor implements CarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Visiting "+ wheel.getName()
                            + " wheel");
    }
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }
    public void visit(Body body) {
        System.out.println("Visiting body");
    }
    public void visit(Car car) {
        System.out.println("Visiting car");
    }
}
// CarElementPrintVisior 클래스는 CarElementVisitor 인터페이스를 확장하여, 각 데이터에 visit 할 시 각 데이터에 대한 print 하는 기능을 한다.


class CarElementDoVisitor implements CarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Kicking my "+ wheel.getName() + " wheel");
    }
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
}
// CarElementDoVisior 클래스는 CarElementVisitor 인터페이스를 확장하여, 각 데이터에 visit 할 시 각 데이터에 대한 실행하는 기능을 한다. (실제 동작하는 로직은 아니지만 Print 문에서 각 데이터에 대한 기능을 가정하여 명시하였다.)


public class VisitorDemo {
    static public void main(String[] args){
        Car car = new Car();
        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
    }
}
// VisitDemo 클래스를 통하여 데이터를 담당하는 Car 클래스를 생성하고, CarElementPrintVistor, CarElementDoVisitor를 통하여 출력, 실행 기능을 하는 코드를 작성하였다.실행 화면

Visiting front left wheel
Visiting front right wheel
Visiting back left wheel
Visiting back right wheel
Visiting body
Visiting engine
Visiting car
Kicking my front left wheel
Kicking my front right wheel
Kicking my back left wheel
Kicking my back right wheel
Moving my body
Starting my engine
Starting my car
```

### 참고 문헌

[https://ko.wikipedia.org/wiki/%EB%B9%84%EC%A7%80%ED%84%B0_%ED%8C%A8%ED%84%B4]
[https://kunoo.tistory.com/entry/%ED%96%89%EC%9C%84-%ED%8C%A8%ED%84%B4-Visitor-pattern-%EB%B9%84%EC%A7%80%ED%84%B0-%ED%8C%A8%ED%84%B4]
[https://blog.hansoolabs.com/564]
