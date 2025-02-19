package algo03.StackAndQueue;

import java.util.Stack;

public class stack_reversePolish {

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens)); // 9
	}

	public static int evalRPN(String[] tokens) {
		// 리버스 Polish 표기법 (후위 표기법)
		// 후위 표기법을 사용하여 수식을 계산하는 문제
		// 스택을 사용하여 연산자와 피연산자를 처리
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				switch (token) {
				case "+":
					stack.push(a + b);
					break;
				case "-":
					stack.push(a - b);
					break;
				case "*":
					stack.push(a * b);
					break;
				case "/":
					stack.push(a / b);
					break;
				}
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}
