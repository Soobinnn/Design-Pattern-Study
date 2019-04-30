package command;
/*
 * 각 명령에 대한 클래스.
 * Receiver 객체를 가지고, Receiver의 메서드를 호출시킨다.
 * Demo할 때 알아보기 쉽도록 toString을 별도로 구현하였다.
 */
class MoveUpCommand implements Command {
	private PlayerReceiver player;
	
	public MoveUpCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveUp();
	}
	
	public String toString() {
		return "Move up";
	}

}

class MoveDownCommand implements Command {
	private PlayerReceiver player;
	
	public MoveDownCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveDown();
	}
	
	public String toString() {
		return "Move down";
	}

}

class MoveLeftCommand implements Command {
	private PlayerReceiver player;
	
	public MoveLeftCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveLeft();
	}
	
	public String toString() {
		return "Move left";
	}

}

class MoveRightCommand implements Command {
	private PlayerReceiver player;
	
	public MoveRightCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.moveRight();
	}
	
	public String toString() {
		return "Move right";
	}

}

class PrintPositionCommand implements Command {
	private PlayerReceiver player;
	
	public PrintPositionCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.printPosition();
	}
	
	public String toString() {
		return "Print position";
	}

}

class ShotToggleCommand implements Command {
	private PlayerReceiver player;
	
	public ShotToggleCommand(PlayerReceiver player) {
		this.player = player;
	}
	
	@Override
	public void execute() {
		player.shotToggle();
	}
	
	public String toString() {
		return "Shot toggle";
	}

}

