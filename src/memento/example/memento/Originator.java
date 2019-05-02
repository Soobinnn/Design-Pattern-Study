package memento;

public class Originator {
	private String title;
	private String content;
	
	public Originator(String title, String content) {
		this.title = title;
		this.content = content;
	}

	// 상태 지정할 때 사용할 용도. 메멘토에서 사용한다.
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public void setTitle(String title) { this.title = title; }
	public void setContent(String content) { this.content = content; }

	// 현재 상태를 저장한다.
	public Memento createMemento() {
		return new Memento(this.title, this.content);
	}

	// 지정한 상태로 되돌아간다.
	public void setMemento(Memento memento) {
		memento.setState(title, content);
	}
	
	// 내용 확인
	public String toString() {
		return String.format("제목: %s\n내용: %s\n", title, content);
	}
}
