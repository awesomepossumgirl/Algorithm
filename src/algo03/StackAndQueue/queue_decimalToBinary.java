package algo03.StackAndQueue;

import java.util.Stack;

public class queue_decimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String solution(int decimal) {
		// 10진수를 2진수로
		Stack<Integer> stack = new Stack<>(); // 나머지를 저장할 스택

		while (decimal != 0) { // 몫이 0이 될 때 까지 반복
			stack.push(decimal % 2); // 나머지 스택에 넣기
			decimal /= 2; // 2로 나누기
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()); // 스택에 있는 나머지 꺼내기
		}
		return sb.toString();
	}
}
