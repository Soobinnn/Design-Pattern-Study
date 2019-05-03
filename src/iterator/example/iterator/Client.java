package iterator;

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
