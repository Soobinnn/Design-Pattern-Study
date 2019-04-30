package strategy;

public class Strategy1 implements MonsterBall{

	@Override
	public int throwBall() {
		System.out.println("몬스터 볼을 던진다.(확률:20%, 가격: 천원)");
		return 1;
	}
}
