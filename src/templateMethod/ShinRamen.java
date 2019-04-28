package templateMethod;

public class ShinRamen extends Ramen{

	@Override
	public void water() {
		System.out.println("물을 550ml 넣고 끓인다.");
		
	}

	@Override
	public void boil() {
		System.out.println("물이 끓으면 면, 분말스프, 후레이크를 같이 넣고 4분30초 동안 더 끓인다.");
		
	}

}
