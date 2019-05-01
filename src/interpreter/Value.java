package interpreter;

// Terminal Expression
public class Value extends Expression{
	int data;
	public Value(int data) {
		this.data = data;
	}
	
	@Override
	int Interpreter() {
		return this.data;
	}

}
