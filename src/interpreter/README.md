# 인터프리터 패턴 (Interpreter pattern)

#### 유재국

## 인터프리터 패턴(Interpreter pattern)이란? 

어떤 언어에 대해, 그 언어의 문법에 대한 표현을 정의하면서, 정의한 표현을 사용하여 해당 언어로 기술된 문장을 해석하는 해석자를 함께 정의하는 패턴.

## 문제 - 언제 패턴을 사용하는가?

특정한 종류의 문제가 자주 발생할 때에, 어떤 간결한 언어를 써서 그 문제를 문장으로 표현하는 것이 나을 수가 있다. DB나 네트워크, 컴퓨터에서 보면 어려운 시스템적인 명령을 하는게 아닌 SQL, 통신 프로토콜, 프로그래밍 랭귀지와 같이해석하는 해석자 문장을 만들어 문장을 해석하게 하여 문제를 해결

## 해결방안 - 설계를 구성하는 요소 간의 관계 (클래스 다이어그램)


![](https://github.com/Soobinnn/Design-Pattern-Study/blob/master/src/interpreter/W3sDesign_Interpreter_Design_Pattern_UML.jpg)
## 결과 - 적용해서 얻는 결과

특정한 문제의 해결에 필요한 코드를 작성하기 보다는 간단한 표현으로 반복적으로 작성하기만 하면 문제를 해결

### - 장점

문법의 변경과 확장이 쉬움 - 패턴에서 문법에 정의된 규칙을 클래스로 표현했기 때문에 문법을 변경하고나 확장하고자 할때는 상속을 이용하면 간단하며, 확장을 통해 기존의 표현식을 지속적으로 수정하거나 새로운 서브클래스 정의를 통해 새로운 표현식을 만들 수 있음

### - 단점

복잡한 문법은 관리하기 어려움 - 규칙별로 적어도 하나의 클래스를 정의해야 하는데, 정의한 규칙별로 관계를 만들려면 훨씬 더 많은 클래스들을 정의해야 하기 때문

## 코드 예제

![](https://github.com/Soobinnn/Design-Pattern-Study/blob/master/src/interpreter/Interpreter%20Pattern%20%E1%84%8B%E1%85%A6%E1%84%8C%E1%85%A6%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%20%E1%84%80%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A8%E1%84%83%E1%85%A9.png)

일반 수학에서 사용하는 중위 표기식이 아닌 후위 표기식을 예제로 들었다.

사용 예제의 클래스 다이어그램

```java

public abstract class Expression {
	abstract int Interpreter();
}
// 해석자의 추상 클래스이며, 연산을 수행할 Interpreter 추상 함수를 갖음


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
// Minus 연산을 수행할 Minus 클래스, Interpreter 함수는 왼쪽 표현식에서 오른쪽 표현식 감소시키는 역할을 수행


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
// Plus 연산을 수행할 Plus 클래스, Interpreter 함수는 왼쪽 표현식에서 오른쪽 표현식 증가시키 역할을 수행


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
// 단일 값을 갖는 Value클래스, Interpreter 함수는 자신의 data를 반환


import java.util.Stack;
public class Main {
	public static void main(String[] args) {
		Expression syntaxTree;
		String expression = "11 7 4 - + 14 -";
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
// Main 클래스에서는 후위 표기식 "11 7 4 - + 14 -" 을 해석하여 결과값을 돌려줌.

### 참고문헌

[https://ko.wikipedia.org/wiki/%EC%9D%B8%ED%84%B0%ED%94%84%EB%A6%AC%ED%84%B0_%ED%8C%A8%ED%84%B4]
