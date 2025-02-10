package algo01.Greedy;

import java.util.Stack;

public class TheLargestNumber {

	public static void main(String[] args) {
		// 프로그래머스
		System.out.println(solution("1924", 2)); // 출력: "94"
		System.out.println(solution("1231234", 3)); // 출력: "3234"
		System.out.println(solution("4177252841", 4)); // 출력: "775841"
	}

	public static String solution(String number, int k) {
		Stack<Character> stack = new Stack<>();

		for (char digit : number.toCharArray()) {
			while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(digit);
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder answer = new StringBuilder();
		for (char digit : stack) {
			answer.append(digit);
		}
		return answer.toString();
	}

}