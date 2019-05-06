package chainOfResponsibility;

public class SocketException extends Problem{

	@Override
	public Problem cause() {
		if("socket".equals(msg)) {
			System.out.println("소켓 문제 발생! SocketException 객체 생성");
			num = 0;
			return this;
		}
		
		//다음 객체 ㄱㄱ
		return next(msg);
	}
}
