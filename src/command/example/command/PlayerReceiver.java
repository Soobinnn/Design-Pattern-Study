package command;

/*
 * 플레이어 동작
 * 슈팅 게임에 대한 활동(상하좌우 이동, 미사일 발사(On/Off), 현재 위치 확인)을 할 수 있다.
 * 활동 반경은 가로 100(0~99), 세로 200(0~199)이라고 하자. 
 */
public class PlayerReceiver {
	private String nickname;
	private int positionX;
	private int positionY;
	private boolean isShot;
	
	public PlayerReceiver(String nickname) {
		this.nickname = nickname;  
		positionX = 50;
		positionY = 10;
		isShot = false;
	}
	
	// 닉네임 변경
	public void changeNickname(String nickname) {
		this.nickname = nickname;
	}
	
	// 상하좌우 이동
	public void moveUp() {
		positionY = (positionY < 200) ? positionY + 1 : 200;
	}
	public void moveDown() {
		positionY = (positionY > 1) ? positionY - 1 : 1;
	}
	public void moveLeft() {
		positionX = (positionX > 1) ? positionX - 1 : 1;
	}
	public void moveRight() {
		positionX = (positionX < 100) ? positionX + 1 : 100;
	}
	// 현재 위치 확인
	public void printPosition() {
		System.out.printf("현재 %s 님의 위치는 (%d, %d)입니다.\n", nickname, positionX, positionY);
	}
	
	// 미사일 자동 발사 지정
	public void shotToggle() {
		if(!isShot) {
			System.out.println("미사일을 자동으로 발사합니다.");
			isShot = true;
		} else {
			System.out.println("미사일 자동 발사를 중지합니다.");
			isShot = false;
		}
	}
	
}
