package interpreter;

// NonTerminal Expression
public class Plus extends Expression{
	Expression leftValue;
	Expression rightValue;
	
	public Plus(Expression leftValue, Expression rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}
	
	@Override
	int Interpreter() {
		return this.leftValue.Interpreter() + this.rightValue.Interpreter();
	}

}
