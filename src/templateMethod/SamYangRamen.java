package templateMethod;

public class SamYangRamen extends Ramen{

	@Override
	public void water() {
		System.out.println("물을 550ml 넣고 끓인다.");
		
	}

	@Override
	public void boil() {
		System.out.println("물이 끓으면 면, 분말스프, 후레이크를 같이 넣고 약 3~4분간 더 끓인다.");
		
	}

}
