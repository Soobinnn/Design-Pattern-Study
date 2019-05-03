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
- 컬렉션 종류에 관계 없이 일관성있게 프로그래밍 할 수 있다.
- 집합 객체의 다양한 순회 방법을 제공한다. 다른 순회 방법을 지정하고 싶다면, Iterator는 순회 알고리즘을 바꿀 수 있도록 한다.
- Iterator의 순회 인터페이스는 Aggregate 클래스에 정의한 자신과 비슷한 인터페이스들을 없애서 Aggregate 클래스의 인터페이스를 단순화시킬 수 있다.
- 각 Iterator마다 자신의 순회 상태가 있으므로 집합 객체에 따라 하나 이상의 순회 방법을 제공할 수 있다.

### 단점
- 아무래도 직접 참조하는 방법보다는 속도가 떨어질 수 있다.


## 코드 예제
코드는 `example/iterator`에 있다.

집합 객체 인터페이스이다. 여기에 반복자 객체를 생성하는 기능을 정의하여 반복자 객체를 이용하여 집합 객체를 순회시키도록 한다. iterator에는 mode를 인자로 주도록 하여 ClassCastException이 나지 않도록 조치하였다.

```java
public interface Aggregate {
	public Iterator iterator(String mode);
}
```

집합 객체인 ItemInventory와 이를 이루는 객체인 Item 객체를 구현하였다.

```java
class Item {
	private String name;
	private int value;
	
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String toString() {
		return String.format("[Item] %s: %d", name, value);
	}
}

// 간단한 아이템 인벤토리 자료구조 구현. ArrayList와 유사하다.
// 원래대로라면 예외 처리를 해줘야 한다. (빈 상태에서 조회 또는 마지막 인덱스보다 큰 인덱스의 값을 참조하려고 할 때)
public class ItemInventory implements Aggregate {
	private Item[] inventory;
	private int size;
	private int last;
	
	public ItemInventory(int size) {
		this.size = size;
		inventory = new Item[size];
		last = 0;
	}
	
	public int getSize() {
		return last;
	}
	
	public void addItem(Item item) {
		if(last > 0 && last == size) {
			resize();
		}
		inventory[last++] = item;
	}
	private void resize() {
		Item[] newInventory = new Item[size * 2];
		for(int i = 0; i < size; i++) {
			newInventory[i] = inventory[i];
		}
		this.inventory = newInventory;
		size = size * 2;
	}
	
	public Item get(int index) {
		return inventory[index];
	}

	@Override
	public Iterator iterator(String mode) {
		// 옵션에 따라 다른 반복자를 반환하도록 작성
		if("normal".equalsIgnoreCase(mode)) {
			return new ItemIterator(this);
		} else if("reverse".equalsIgnoreCase(mode)) {
			return new ItemReverseIterator(this);
		}
		return null;
	}
}
```

반복자 객체를 정의하였다. 반복자 객체에는 가장 첫 번째 원소, 다음 원소로 넘어가는 기능, 순회가 끝났는지, 현재 원소를 반환하는 기능을 정의한다.

```java
cpublic interface Iterator {
	public Object first();
	public Object next();
	public boolean isDone();
	public Object CurrentItem();
}
```

반복자 객체로는 오름차순으로 탐색하는 ItemIterator와 내림차순으로 탐색하는 ItemReverseIterator를 구현하였다.

```java
// 오름차순으로 순회하는 반복자
public class ItemIterator implements Iterator {
	private ItemInventory inventory;
	private int index;
	
	public ItemIterator(ItemInventory inventory) {
		this.inventory = inventory;
		index = 0;
	}

	@Override
	public Object first() {
		return inventory.get(0);
	}

	@Override
	public Object next() {
		return inventory.get(index++);
	}

	@Override
	public boolean isDone() {
		return index >= inventory.getSize();
	}

	@Override
	public Object CurrentItem() {
		return inventory.get(index);
	}
}
```

```java
// 내림차순으로 순회하는 반복자
public class ItemReverseIterator implements Iterator {
	private ItemInventory inventory;
	private int index;
	
	public ItemReverseIterator(ItemInventory inventory) {
		this.inventory = inventory;
		index = inventory.getSize() - 1;
	}

	@Override
	public Object first() {
		return inventory.get(inventory.getSize() - 1);
	}

	@Override
	public Object next() {
		return inventory.get(index--);
	}

	@Override
	public boolean isDone() {
		return index < 0;
	}

	@Override
	public Object CurrentItem() {
		return inventory.get(index);
	}
}
```

클라이언트이다. 사용자는 직접 ItemInventory를 참조하지 않고 반복자 객체를 사용하여 ItemInventory를 탐색할 수 있다.  
또한, 원하는 방식으로 탐색하도록 새로운 반복자 클래스를 정의하면 그 방식대로 탐색하는 것이 가능함을 확인할 수 있다.

```java
public class Client {
	public static void main(String[] args) {
		ItemInventory inventory = new ItemInventory(5);
		inventory.addItem(new Item("만티코어", 10000));
		inventory.addItem(new Item("왕실 권위의 반지", 7000));
		inventory.addItem(new Item("독수리뿔 장궁", 3000));
		inventory.addItem(new Item("파멸의 인도자", 12000));
		inventory.addItem(new Item("설퍼라스", 30000));
		inventory.addItem(new Item("망자의 유산", 4000));
		
		
		System.out.println("오름차순으로 탐색");
		ItemIterator itemIterator = (ItemIterator)inventory.iterator("normal");
		iteration(itemIterator);
		System.out.println("-----------------");
		System.out.println("내림차순으로 탐색");
		ItemReverseIterator itemReverseIterator = (ItemReverseIterator)inventory.iterator("reverse");
		iteration(itemReverseIterator);
		System.out.println("-----------------");
	}
	
	public static void iteration(Iterator iterator) {
		while(!iterator.isDone()) {
			Item item = (Item) iterator.next();
			System.out.println(item);
		}
	}
}
```

실행 결과는 다음과 같다.

```
오름차순으로 탐색
[Item] 만티코어: 10000
[Item] 왕실 권위의 반지: 7000
[Item] 독수리뿔 장궁: 3000
[Item] 파멸의 인도자: 12000
[Item] 설퍼라스: 30000
[Item] 망자의 유산: 4000
-----------------
내림차순으로 탐색
[Item] 망자의 유산: 4000
[Item] 설퍼라스: 30000
[Item] 파멸의 인도자: 12000
[Item] 독수리뿔 장궁: 3000
[Item] 왕실 권위의 반지: 7000
[Item] 만티코어: 10000
-----------------

```


### 참고문헌
- GoF의 디자인 패턴
- [Iterator](https://www.dofactory.com/net/iterator-design-pattern)
- [Java Iterator 개념 및 사용방법](https://farmerkyh.tistory.com/844)
