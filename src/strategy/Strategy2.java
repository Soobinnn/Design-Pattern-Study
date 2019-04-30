package strategy;

public class Strategy2 implements MonsterBall{

	@Override
	public int throwBall() {
		System.out.println("하이퍼볼을 던진다.(확률:50%, 가격: 삼천원)");
		return 4;
	}
}
