package iterator;

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
