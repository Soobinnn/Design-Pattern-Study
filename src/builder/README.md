# 빌더 패턴 (Builder pattern)

#### 작성자 : 남기웅

## 빌더 패턴(Builder pattern pattern)이란?

**빌더 패턴**(Builder pattern)이란 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴이다.

## 문제 - 언제 패턴을 사용하는가?

객체의 생성은 보통 생성자를 통하여 이루어진다. 생성자는 초기화할 속성들을 매개변수로 가지며 , 속성의 종류는 크게 다음과 같이 나뉜다.

| **구분**  | **내용**                            |
| --------- | ----------------------------------- |
| 필수 속성 | 반드시 초기화 되어야 하는 속성      |
| 선택 속성 | 반드시 초기화 되지 않아도 되는 속성 |

예를 들어 다음 예제를 보자.

**예제1) 일반적 방법**

```java
public class Person {

    //필수 사항
	private String name;
	private int age;
	private String job;
	
    //선택 사항
	private String location;
	private String hobby;

  	//일반적 방법
	//생성자1
	public Person(String name,int age,String job) {
	    this.name=name;
		this.age=age;
		this.job=job;
	}
	//생성자2
	public Person(String name,int age,String job,String location) {
		this.name=name;
		this.age=age;
		this.job=job;
		this.location=location;
	}
	//생성자3
	public Person(String name,int age,String job,String location,String hobby) {
		this.name=name;
        this.age=age;
        this.job=job;
        this.location=location;
        this.hobby=hobby;
    } 

	public static void main(String[] args) {

        // 일반적 방법
        //생성자1 이용
        Person person1 = new Person("김기기",27,"Student");

        //생성자2 이용
        Person person2 = new Person("남기웅",27,"Programmer","Seoul");

        //생성자3 이용
        Person person3 = new Person("박무무",40,"건물    주","Seoul","월세 받기");
	}

}
```

필수 속성은 3가지(name,age,job)이고 선택속성은 2가지(location,hobby)다. 

선택속성의 경우의 수를 만족시켜주기 위하여 총 3개의 생성자가 존재한다.

여기서 만약 , 선택 속성으로 키 , 혈액형 같은것들을 추가하면 어떻게 될까?

선택속성이 늘어난 만큼 생성자를 더 만들어 주어야 되며 실제 객체를 생성할때에 각 생성자의 시그니처를 정확히 알고 있어야 될 것이다.

시그니처의 순서를 몰라도 객체 생성을 쉽게 하는 방법은 없을까?



다음은 시그니처의 순서를 몰라도 객체의 속성값을 설정할 수 있는 방안이다. 이 방법은 생성자를 이용하지 않는 방법이다.



**예제2)자바빈 패턴**

```java
public class Person {

    //필수 사항
    private String name;
    private int age;
    private String job;

    //선택 사항
    private String location;
    private String hobby;

    //자바빈 패턴    
	public void setName(String name) {

        this.name=name;

    }

    public void setAge(int age) {

        this.age=age;

    }

    public void setJob(String job) {

        this.job=job;

    }

    public void setLocation(String location) {

        this.location=location;

    }

    public void setHobby(String hobby) {

        this.hobby=hobby;

    }

    public static void main(String[] args) {

        //자바빈 패턴        
        Person person1 = new Person();
        person1.setName("김기기");
        person1.setAge(27);
        person1.setJob("Student");

        Person person2 = new Person();
        person2.setName("남기웅");
        person2.setAge(27);
        person2.setJob("Programmer");
        person2.setLocation("Seoul");

        Person person3 = new Person();
        person3.setName("박무무");
        person3.setAge(40);
        person3.setJob("건물주");
        person3.setLocation("Seoul");
        person3.setHobby("월세 받기");    

    }

}
```

위 코드는 생성자로 초기화를 하지않고 setter를 이용하여 속성을 초기화함으로써 코드를 작성할때 시그니처 순서를 알 필요가 없다. 

하지만 위와같은 코드의 문제점은 필수 속성이 초기화가 되지 않을 수도 있다. 



## 해결방안 - 설계를 구성하는 요소간의 관계 (클래스다이어그램)

![](.\img\builder.png)

​											빌더 패턴 클래스 다이어그램 (출처 : 위키백과)



**위 클래스 다이어그램은 빌더 패턴의 개념적 클래스 다이어그램이다.**

**● Director : Builder 객체를 이용하여 Product 객체를 만드는 클래스**

**● Builder : Product 객체의 필수요소를 초기화 시켜주고 선택요소를 설정할 수 있도록 해주는 클래스 또는 인터페이스(AbstractBuilder class)**

**● ConcreteBuilder : Builder를 구현한 클래스 (Builder class)**

**● Product : 객체 생성의 대상이 되는 클래스 (Person class)**

**위 예제에서는 Product의 내부에 Builder 를 구현하였다. (Director 클래스가 별도로 없다.)**



여태까지의 문제를 정리하면 두가지가 있다.

1. 선택적 속성이 늘어남에 따라 생성자 또한 여러개 정의하여야 함(예제1)

2. 필수 속성의 초기화를 보장하지 않음 (예제2)

위 두가지 문제를 해결해주는 패턴이 빌더 패턴이다.



**예제3)빌더 패턴**

```java
public class Person {

   //필수 사항
    private String name;
    private int age;
    private String job;

    //선택 사항
    private String location;
    private String hobby;



    /* 빌더 패턴*/    

    private Person(String name,int age,String job,String location,String hobby) 	{
        this.name=name;
        this.age=age;
        this.job=job;
        this.location=location;
        this.hobby=hobby;
    }



    public static class Builder implements AbstractBuilder{

        //필수 사항
		private String name;
        private int age;
        private String job;

        //선택 사항
        private String location;
        private String hobby;

        public Builder(String name,int age,String job) {
            this.name=name;
            this.age=age;
            this.job=job;

        }

        public Builder setLocation(String location) {
            this.location=location;
            return this;
        }


        public Builder setHobby(String hobby) {
            this.hobby=hobby;
            return this;
        }


        public Person build() {
            return new Person(name,age,job,location,hobby);
        }

        public static void main(String[] args) {

            /* 빌더 패턴 */        

            Person.Builder builder = new Person.Builder("김기기",27,"Student"); 			
            Person person1=builder.build();

            Person.Builder builder2 = new Person.Builder("남기    웅",27,"Programmer").setLocation("Seoul");


            Person person2=builder2.build();

            Person.Builder builder3 = new Person.Builder("박무무",40,"건물주")
                .setLocation("Seoul")
                .setHobby("월세 받기");

            Person person3=builder3.build();    

        }

    }
```



## 결과 - 적용해서 얻는 결과

<b>- 장점 </b>: 필수 속성의 초기화를 보장해주며 선택속성에 갯수에 비례한 생성자를 만들 필요가 없다.

<b>- 단점</b>: 클래스의 속성의 갯수가 많아질수록 복잡해 질 수 있다.



### 참고문헌

[https://ko.wikipedia.org/wiki/%EB%B9%8C%EB%8D%94_%ED%8C%A8%ED%84%B4](https://ko.wikipedia.org/wiki/빌더_패턴)

<https://johngrib.github.io/wiki/builder-pattern/>