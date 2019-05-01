package interpreter;

// NonTerminal Expression
public class Minus extends Expression{
	Expression leftValue;
	Expression rightValue;
	
	public Minus(Expression leftValue, Expression rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}
	
	@Override
	int Interpreter() {
		return this.leftValue.Interpreter() - this.rightValue.Interpreter();
	}

}
