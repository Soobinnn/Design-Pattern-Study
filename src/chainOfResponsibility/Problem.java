package chainOfResponsibility;

public abstract class Problem {
	
	private static Problem[] list = {new SocketException(), new NullPointException(), new IOException()};
	protected static Integer num = 0;
	protected static String msg;
	
	public static Problem next(String error) {
		msg = error;
		
		if(num == list.length) {
			System.out.println("어떤 에러인지 확인 불가능");
			return null;
		}
		
		return list[num++].cause();
	}

	
	public abstract Problem cause();
}
