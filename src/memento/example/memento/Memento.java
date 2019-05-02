package memento;

public class Memento {
	private final Originator originatorState;
	
	public Memento(String title, String content) {
		originatorState = new Originator(title, content);
	}
	
	// 객체로 저장한 상태 정보를 가져온다.
	public Originator getState() {
		return originatorState;
	}
	
	// 상태 정보를 저장한다.
	public void setState(String title, String content) {
		originatorState.setTitle(title);
		originatorState.setContent(content);
	}
}
