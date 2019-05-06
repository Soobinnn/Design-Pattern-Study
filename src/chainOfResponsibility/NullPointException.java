package chainOfResponsibility;

public class NullPointException extends Problem{

	@Override
	public Problem cause() {
		
		if("null".equals(msg)) {
			System.out.println("객체에 Null 값이 들어감. NullPointException 객체 생성");
			num = 0;
			return this;
		}
		
		//다음 객체 ㄱㄱ
		return next(msg);
		
	}
}
