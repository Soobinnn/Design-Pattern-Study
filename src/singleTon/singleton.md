# 싱글톤 패턴 (Singleton pattern)

### 작성자
임수빈

### 싱글톤 패턴(Singleton pattern)이란? 
애플리케이션이 시작될 때 어떤 클래스가 **최초 한번만 메모리를 할당**하고(static)
그 메모리에 인스턴스를 하나만 만들어질 수 있도록해서 사용하는 디자인패턴

인스턴스가 프로그램 내에서 오직 하나만 생성되는 것을 보장하고,
프로그램 어디에서든 이 인스턴스에 접근할 수 있도록 하는 패턴

인스턴스가 사용될 때 똑같은 인스턴스를 여러 개 만드는 것이 아니라,
기존에 생성했던 동일한 인스턴스를 사용하게끔 하는 것

### 사용하는 이유
	1. 메모리 낭비 방지

		- 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있음.

	2. 데이터 공유 용이

		- 전역 인스턴스 이기 때문에 다른 클래스들의 인스턴스들이 데이터를 공유하기 쉬움.

	3. 성능 우수

		- DBCP(DataBase Connection Pool)같은 공통된 객체를 여러개 생성해서 사용할 상황에 사용

		  (쓰레드 풀, 캐시, 로그 등)

		  매번 객체를 생성하지 않고 같은 객체를 사용하도록 하여 성능 향상시킴.


#### * 사용 조건 
	- Java

	: 생성자를 private로 선언해서 생성 불가하게 하고 getInstance()로 받아씀

	- Python

	: 파이썬의 모듈은 그 자체로 싱글턴임

### 문제점
: 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우,

다른 클래스의 인스턴스들 간에 결합도가 높아져 __"개방-폐쇄 원칙"__ 을 위배하게 됨.(객체지향 설계 원칙에 어긋남)

-> 수정이 어려워지고 테스트하기 어려워짐


#### * 개방-폐쇄 원칙 (Open-Closed Principle)

: 객체지향기법 5원칙 중 하나로, 확장에 대해서는 개방되어야 하지만, 변경에 대해서는 폐쇄되어야 한다.라는 의미

변경을 위한 비용을 가능한 줄이고, 확장을 위한 비용은 가능한 극대화 해야함.
-> 객체간의 관계를 단순화해 복잡도를 줄이고, 확장-변경에 따른 충격을 줄이는데 있음.
### 클래스다이어그램 
![singleton UML](./img/singleton.png)

### 코드예제
**고전적인 싱글톤 패턴 구현법**

#### 1. Eager Initialization
```java
/*
 * [예제1] 가장 기본적인 SingleTon Pattern
 * private static을 이용해서 static이 붙은 클래스 변수를 인스턴스화에 상관없이 사용가능하게됨.
 * 
 * 1. 생성자를 private로 명시함.
 *  
 * EagerInitialization();으로 인해 클래스가 load 되는 시점에 인스턴스를 생성시키는데 이마저도 부담스러울 수가 있다. 
 * 또한 이 소스는 EagerInitialization 클래스가 인스턴스화 되는 시점에 어떠한 에러처리도 할 수가 없다.
 */
public class EagerInitialization 
{
		// private static 로 선언.
		private static EagerInitialization instance = new EagerInitialization();
		
		// 생성자
		private EagerInitialization () 
		{
			System.out.println( "call EagerInitialization constructor." );
		}
		// 조회 method
		public static EagerInitialization getInstance () 
		{
			return instance;
		}
		
		public void print () 
		{
			System.out.println("It's print() method in EagerInitialization instance.");
			System.out.println("instance hashCode > " + instance.hashCode());
		}
}

```
: 가장 기본적인 싱글톤 패턴. 전역 변수로 instance를 만드는데 private static을 이용함.

클래스가 load 되는 시점에 인스턴스를 생성시키는데 이마저도 부담스러울 수가 있다.  
또한 이 소스는 EagerInitialization 클래스가 인스턴스화 되는 시점에 어떠한 에러처리도 할 수가 없다.

#### 2. Static block Initialization
: static 초기화 블럭을 이용한 싱글톤 패턴.

초기화블럭을 이용하면 logic을 담을 수 있기 때문에 복잡한 초기변수 세팅, 에러처리를 위한 구문을 담을 수 있음.  
Eager Initialization에서 못했던 에러처리를 할 수 있지만, 인스턴스가 사용되는 시점에 생성되는 것은 아님.
- 메모리 낭비
```java
/*
 * [예제2] static 초기화 블럭을 이용한 sigleTon
 * 초기화블럭을 이용하면 logic을 담을 수 있기 때문에 복잡한 초기변수 세팅, 에러처리를 위한 구문을 담을 수 있음.
 * [예제1]보다 좋아보이지만, 인스턴스가 사용되는 시점에 생성되는 것은 아님.
 */
public class StaticBlockInitalization 
{
	private static StaticBlockInitalization instance;
	private StaticBlockInitalization () {}
	
	static 
	{
		try 
		{
			System.out.println("instance create..");
			instance = new StaticBlockInitalization();
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Exception creating StaticBlockInitalization instance.");
		}
	}
	
	public static StaticBlockInitalization getInstance () 
	{
		return instance;
	}
	
	public void print () 
	{
		System.out.println("It's print() method in StaticBlockInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}

```

#### 3. Lazy Initialization

: 클래스인스턴스가 사용되는 시점에 인스턴스를 만드는 싱글톤 패턴

최초 사용시점에만 인스턴스화 시키기 때문에 프로그램이 메모리에 적재되는 시점에 부담이 많이 줄게됨.  
하지만 문제점은 남아있다.  MultiThread방식이라면, singletonPattern이 안전하지 않음.  
즉, 동일 시점에 getInstance() method를 호출하면 인스턴스가 두번 생길 위험이 있음.

```java
/*
 * [예제3] 클래스인스턴스가 사용되는 시점에 인스턴스를 만드는 singleton pattern
 *  최초 사용시점에만 인스턴스화 시키기 때문에 프로그램이 메모리에 적재되는 시점에 부담이 많이 줄게됨.
 *  하지만 문제는 남아있음.
 *  MultiThread방식이라면, singletonPattern은 안전하지 않음.
 *  즉, 동일 시점에 getInstance() method를 호출하면 인스턴스가 두번 생길 위험이 있음. 
 */
public class LazyInitialization 
{
	private static LazyInitialization instance;
	private LazyInitialization () {}
	
	public static LazyInitialization getInstance () 
	{
		if ( instance == null )
			instance = new LazyInitialization();
		return instance;
	}
	
	public void print () 
	{
		System.out.println("It's print() method in LazyInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}

```

### **멀티쓰레드에서 안전한 싱글톤 패턴 구현법**

#### 4. Thread safe Lazy Initialization

:  멀티쓰레드 문제를 해결하기 위한 동기화  싱글톤 패턴

synchronized를 사용하여 구현해서 thread들이 동시에 접근해서 인스턴스를 생성시키는 위험은 없어짐.
하지만, 수 많은 thread들이 getInstance()메소드를 호출하게되면
synchronized 특성상  비교적 큰 성능저하가 발생하므로  권장하지 않는 방법이다.

```java
/*
 * [예제4] 멀티쓰레드 문제를 해결하기 위한 동기화 singleton 패턴
 * 
 * synchronized를 사용하여 구현해서 thread들이 동시에 접근해서 인스턴스를 생성시키는 위험은 없어짐
 *  수 많은  thread들이 getInstance()메소드를 호출하게되면 높은 cost비용으로 인해 프로그램전반에 성능저하가 일어남. 
 *  
 */
public class ThreadSafeInitalization 
{
	private static ThreadSafeInitalization instance;
	private ThreadSafeInitalization () {}
	
	public static synchronized ThreadSafeInitalization getInstance () 
	{
		if (instance == null)
			instance = new ThreadSafeInitalization();
		return instance;
	}
	
	public void print () 
	{
		System.out.println("It's print() method in ThreadSafeInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
```

#### 5. Double-checked locking

: Thread safe Lazy Initialization에서 성능을 완화한 싱글톤 패턴

getInstance()에 synchronized를 사용하는 것이 아니라 첫번째 if문으로 인스턴스의 존재여부를 체크하고,  
if문에서 다시 한번 체크할 때 동기화 시켜서 인스턴스를 생성하므로 thread-safe하면서도 처음 생성 이후에  
synchonized블럭을 타지 않기 때문에 성능저하를 완화했지만,  완벽한 방법은 아님.

```java
/*
 * [예제5] Thread safe lazy initialization + Double-checked Locking
 *  getInstance()에 synchronized를 사용하는 것이 아니라 첫번째 if문으로 인스턴스의 존재여부를 체크하고,
 *  if문에서 다시 한번 체크할 때 동기화 시켜서 인스턴스를 생성하므로 thread-safe하면서도 처음 생성 이후에
 *  synchonized블럭을 타지 않기 때문에 성능저하를 완화했다
 *  완벽한 방법은 아님.
 *  * volatile를 선언한 것을 쓰레드가 바로 읽을 경우, 쓰기 직전에 모든 변수를 스레드가 볼수 있다.
 * */
public class DoubleCheckedLocking 
{
	 private volatile static DoubleCheckedLocking instance;
	 
	 private DoubleCheckedLocking(){}
	     
	 public static DoubleCheckedLocking getInstance()
	 {       
	     if(instance == null)
	     {
	         synchronized (DoubleCheckedLocking.class) 
	         {
	             if(instance == null)
	            	 instance = new DoubleCheckedLocking();
	         }
	     }
	     
	     return instance;
	 }

}
```
#### 6. Initialization on demand holder idiom

: 기존 싱글톤 패턴의 문제를 해결하기 위한 새로운 싱글톤 패턴

JVM의 클래스 초기화 과정에서 보장되는 원자적 특성을 이용하여 싱글톤의 초기화 문제에 대한 책임을

JVM에 떠넘긴다. holder안에 선언된 instance가 static이기 때문에 클래스 로딩시점에 한번만 호출될 것이며,

final을 사용해 다시 값이 할당되지 않도록 만든 방법.

즉 JVM의 class loader의 매커니즘과 class의 load시점을 이용하여 내부 클래스를 생성시킴으로  
thread간의 동기화문제를 해결함.  
lazy initializaition이 가능하며, 모든 java버전과, jvm에서 사용이 가능함.  
**현재 java에서 singleton을 생성시킨다고하면 거의 아래의 방법을 사용함.**
```java
/*[예제6] 기존 싱글톤 패턴의 문제를 해결하기 위한 새로운 싱글톤 패턴
* jvm의 class loader의 매커니즘과 class의 load시점음 이용하여 내부 클래스를 생성시킴으로
* thread간의 동기화문제를 해결함.
* lazy initializaition이 가능하며, 모든 java버전과, jvm에서 사용이 가능함.
* 현재 java에서 singleton을 생성시킨다고하면 거의 아래의 방법을 사용한다고 보면됨.
* 
*/
public class InitializationOnDemandHolderIdiom 
{
	private InitializationOnDemandHolderIdiom () {}
	private static class Singleton 
	{
		private static final InitializationOnDemandHolderIdiom instance = new InitializationOnDemandHolderIdiom();
	}
	
	public static InitializationOnDemandHolderIdiom getInstance () 
	{
		System.out.println("create instance");
		return Singleton.instance;
	}
}

```
#### 7. enum initialization

: 인스턴스가 생성될 때 멀티스레드로 부터 안전함, 단 한번 인스턴스 생성을 보장함.

enum value는 자바 전역에서 접근이 가능함. 구현이 간편함.
```java
/*
 * [예제7]
 *   - 인스턴스가 생성될 때, multi thread 로 부터 안전하다. (추가된 methed 들은 safed 하지 않을 수도 있다.)
     - 단 한번의 인스턴스 생성을 보장한다.
     - 사용이 간편하다.
     - enum value는 자바 프로그램 전역에서 접근이 가능하다.
 * */
public enum EnumInitialization 
{
	INSTANCE;
	static String test = "";
	public static EnumInitialization getInstance() 
	{
		test = "test";
		return INSTANCE;
	}
}
```
### 참고문헌 