package state;
/*
public class Git {
	//패턴 적용 전
	
	private static String NEW_STATUS = "NEW_STATUS";
	private static String ADD = "ADD";
	private static String COMMIT = "COMMIT";
	private static String PUSH = "PUSH";
	private static String state;
	
	public Git() {
		state=NEW_STATUS;
	}
	
	
	public void Do() {
		//NEW_FILE 상태일때는 ADD상태로 
		if("NEW_STATUS".equals(state)) {
			System.out.println("CurrentState : "+state);
			System.out.println("Git Add File");
			state=ADD;
		}
		//ADD 상태일때는 COMMIT상태로
		else if("ADD".equals(state)) {
			System.out.println("CurrentState : "+state);
			System.out.println("Git Commit");
			state=COMMIT;
		}
		//COMMIT 상태일때는 PUSH상태로
		else if("COMMIT".equals(state)) {
			System.out.println("CurrentState : "+state);
			System.out.println("Git Push");
			state=PUSH;
		}
		//PUSH상태일때는 NEW_FILE상태로
		else {
			System.out.println("CurrentState : "+state);
			System.out.println("Create NEW FILE");
			state=NEW_STATUS;
		}
			
	}
}*/

//패턴 적용 후

public interface Git {
	public Git Do();
}
