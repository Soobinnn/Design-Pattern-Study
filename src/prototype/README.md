# 프로토타입 패턴 (Prototype pattern)

### 유재국

## 프로토타입 패턴(Prototype pattern)이란?

패턴은 생성할 객체들의 타입이 프로토타입인 인스턴스로부터 결정되도록 하며, 인스턴스는 새 객체를 만들기 위해 자신을 복제하여 생성되도록 하는 패턴이다.

## 문제 - 언제 패턴을 사용하는가?

프로토타입 패턴의 사용되는 경우는, 새로운 객체는 일반적으로 new 연산자를 사용하여 객체를 생성하는 고유의 비용이 매우 클 때, 이 비용을 감내하지 않을 수 있게 해준다.

## 해결방안 - 설계를 구성하는 요소 간의 관계 (클래스 다이어그램)

![](https://github.com/Soobinnn/Design-Pattern-Study/blob/master/src/prototype/prototype%20pattern%20%E1%84%8B%E1%85%A8%E1%84%8C%E1%85%A6%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A8%E1%84%83%E1%85%A9.png)

## 결과 - 적용해서 얻는 결과

프로토타입 패턴은, 추상 팩토리 패턴과는 반대로, 클라이언트 응용 프로그램 코드 내에서 객체 창조자(creator)를 서브클래스(subclass)하는 것을 피할 수 있게 해준다.

프로토타입 패턴은 새로운 객체는 일반적인 방법(예를 들어, new를 사용해서라든지)으로 객체를 생성(create)하는 고유의 비용이 주어진 응용 프로그램 상황에 있어서 불가피하게 매우 클 때, 이 비용을 감내하지 않을 수 있게 해준다.

### - 장점

클라이언트는 새로운 인스턴스를 만드는 복잡한 과정을 몰라도 된다.

객체를 생성해주기 위한 별도의 객체 생성 클래스가 불필요하다.

객체 생성에 자원 또는 시간이 많이 소요되는 경우(생산비용이 높은 인스턴스)에 객체를 복사하면 효율적이다.

### - 단점

생성될 객체의 클래스에 모두 Clone() 멤버 함수를 구현해야 한다.

## 코드 예제

대부분의 예제에서는 Cloneable을 인터페이스하여 clone함수를 강제하지만, 클래스다이어그램의 예제에서는 Cloneable을 상속받아 clone함수를 사용하여 인스턴스를 복사는데에 중점을 두었다.

~~~Java
public interface Building extends Cloneable{
	public abstract void abilityToDo();
	public abstract Building createClone();
}
// Building interface는 무엇을 할 수 있는지에 대해 알려주는 abilityToDo 추 함수와, 객체를 복사해서 Return 하는 createClone 추상함수로 구성되어있다.


import java.util.HashMap;
public class BuildManager {
	private HashMap buildingList = new HashMap();
	public void register(String buildingName, Building building) {
		buildingList.put(buildingName, building);
	}
	public Building create(String buildingName) {
		Building b = (Building) buildingList.get(buildingName);
		return b.createClone();
	}
}
// BuildManager 클래스는 등록된 BuildingList를 HashMap형태로 가지고 있어, BuildingName과 Building을 인자로 줄시 BuildingList에 등록하는 register함수와, 클라이언트에서 등록되어있는 Building 중에서 생성할 BuildingName을 인자로 줄시 그에 해당하는 Building의 복사본을 반환하는 create 함수로 구성되어있다.


public class Barracks implements Building {
	@Override
	public void abilityToDo() {
		System.out.println("It can produce marine.");
		System.out.println("It can produce firebat.");
		System.out.println("It can produce medic.");
		System.out.println("It can produce ghost.");
	}

	@Override
	public Building createClone() {
		Building b = null;
		try {
			b = (Building)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return b;
	}
}
// Barracks 클래스는 보병유닛을 생산할 수 있는 abilityToDo 함수와 자신을 복제하여 반환하는 createClone 함수로 구성되어있다.


public class CommandCenter implements Building {
	@Override
	public void abilityToDo() {
		System.out.println("It can produce SCV.");
		System.out.println("It can produce Comsat station.");
		System.out.println("It can produce Nuclear silo.");
	}

	@Override
	public Building createClone() {
		Building b = null;
		try {
			b = (Building)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return b;
	}
}
// CommandCenter  클래스는 특수전투차량(Special Combat Vehicle)과 Comsat Station, Nuclear Silo 건물을 제공하는 abilityToDo 함수와 자신을 복제하여 반환하는 createClone 함수로 구성되어있다.


public class EngineeringBay implements Building {
	@Override
	public void abilityToDo() {
		System.out.println("It can upgrade Infantry weapons.");
		System.out.println("It can upgrade Infantry armor.");
	}

	@Override
	public Building createClone() {
		Building b = null;
		try {
			b = (Building)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return b;
	}
}
// EngineeringBay 클래스는 보병유닛의 무기와 방어구를 강화하는 abilityToDo 함수와 자신을 복제하여 반환하는 createClone 함수로 구성되어있다.

import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		BuildManager buildManager = new BuildManager();
		CommandCenter cc = new CommandCenter();
		Barracks b = new Barracks();
		EngineeringBay eb = new EngineeringBay();
		
		buildManager.register("CommandCenter", cc);
		buildManager.register("Barracks", b);
		buildManager.register("EngineeringBay", eb);
		
		System.out.println("press 'b' or 'c' or 'e' ");
		System.out.println("if you want program end. press 'q'");
		char c = new Scanner(System.in).next().charAt(0);
		while(true) {
			if ((int)c == 113){
				System.out.println("press 'q'");
				System.out.println("..quit..");
				break;
			}
			else {
				switch((int)c){
					case 98 :
						Building buildingBarracks = buildManager.create("Barracks");
						buildingBarracks.abilityToDo();
						break;
					case 99 :
						Building buildingCommandCenter = buildManager.create("CommandCenter");
						buildingCommandCenter.abilityToDo();
						break;
					case 101 : 
						Building buildingEnginerringBay = buildManager.create("EngineeringBay");
						buildingEnginerringBay.abilityToDo();
						break;
				}
			}
			System.out.println("press 'b' or 'c' or 'e' ");
			System.out.println("if you want program end. press space-bar");
			c = new Scanner(System.in).next().charAt(0);
		}
	}
}
// Main 클래스에서는 BuildManager에 Building 의 인스턴스들을 등록해두고 while문을 통해서 사용자의 b(Barracks), c(CommandCenter), e(EngineeringBay) 입력을 통한 생산 요청에 Clone을 통해서 반환하여 사용되고있는 형태로 구성되어있다.

~~~

### 참고문헌

[https://blog.naver.com/gamediz/20041448546]

[https://blog.naver.com/sorkelf/40170789000]

[https://kimsunzun.tistory.com/entry/ProtoType-%ED%8C%A8%ED%84%B4-1]
