package interpreter;

import java.util.Stack;
public class Main {
	
	public static void main(String[] args) {
		Expression syntaxTree;
		String expression = "11 7 4 - + 14 -";
		// 
		syntaxTree = evalutor(expression);
		System.out.println(syntaxTree.Interpreter());
	}
	
	public static Expression evalutor(String expression) {
		Expression syntaxTree;
		Stack<Expression> expStack = new Stack<Expression>();
		for(String token : expression.split(" ")) {
			if(token.contentEquals("+")) {
				Expression right = expStack.pop();
				Expression left = expStack.pop();
				System.out.print(left.Interpreter());
				System.out.print("+");
				System.out.println(right.Interpreter());
				Expression subExpression = new Plus(left, right);
				expStack.push(subExpression);
			}else if(token.contentEquals("-")) {
				Expression right = expStack.pop();
                Expression left = expStack.pop();
				System.out.print(left.Interpreter());
				System.out.print("-");
				System.out.println(right.Interpreter());
                Expression subExpression = new Minus(left, right);
                expStack.push( subExpression );
			}else
				expStack.push(new Value(Integer.parseInt(token)));
		}
		syntaxTree = expStack.pop();
		return syntaxTree;
	}
}
