package iterator;

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
