package algo03.StackAndQueue;

import java.util.Stack;

public class stack_validParentheses {

	public static void main(String[] args) {
		// 프로그래머스 올바른 괄호 문제
		stack_validParentheses solution = new stack_validParentheses();

		// 테스트 코드
		System.out.println(solution.solution("()()")); // true
		System.out.println(solution.solution("(()")); // false
		System.out.println(solution.solution("())")); // false
		System.out.println(solution.solution("(())()"));// true
		System.out.println(solution.solution("")); // true
	}

	// 괄호의 짝이 맞는지 확인하는 함수
	boolean solution(String s) {
		// 열린 괄호를 추적할 스택 생성
		Stack<Character> cnt = new Stack<>();

		// 문자열의 각 문자에 대해 반복
		for (int i = 0; i < s.length(); i++) {
			// 열린 괄호 '('를 만나면 스택에 푸시
			if (s.charAt(i) == '(') {
				cnt.push('(');
			}
			// 닫힌 괄호 ')'를 만나면
			else if (s.charAt(i) == ')') {
				// 스택이 비어있으면 짝이 맞지 않으므로 false 반환
				if (cnt.isEmpty()) {
					return false;
				}
				// 스택에서 열린 괄호 '('를 pop
				cnt.pop();
			}
		}

		// 스택이 비어있으면 모든 괄호가 짝을 맞춘 것이므로 true 반환, 아니면 false
		return cnt.isEmpty();
	}

}
