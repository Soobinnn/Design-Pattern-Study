package strategy;

public class Strategy3 implements MonsterBall{

	@Override
	public int throwBall() {
		System.out.println("마스터볼을 던진다.(확률:100%, 가격: 백만원)");
		return 9;
	}
}
