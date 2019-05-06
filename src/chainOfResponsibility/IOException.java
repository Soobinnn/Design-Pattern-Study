package chainOfResponsibility;

public class IOException extends Problem{

	@Override
	public Problem cause() {
		
		if("IO".equals(msg)) {
			System.out.println("입력 값 오류 발생! IOException 객체 생성");
			num = 0;
			return this;
		}
		
		//다음 객체 ㄱㄱ
		return next(msg);
	}

}
