package iterator;

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
