package algo03.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class noMoreSameNums {

	public static void main(String[] args) {
		// 프로그래머스 같은 숫자는 싫어 문제
		noMoreSameNums solution = new noMoreSameNums();

		// 테스트 1
		int[] arr1 = { 1, 1, 3, 3, 0, 1, 1 };
		System.out.println("Test 1: " + Arrays.toString(solution.solution(arr1))); // [1, 3, 0, 1]

		// 테스트 2
		int[] arr2 = { 4, 4, 4, 3, 3, 2, 2 };
		System.out.println("Test 2: " + Arrays.toString(solution.solution(arr2))); // [4, 3, 2]

		// 테스트 3
		int[] arr3 = { 7, 8, 8, 7, 9, 7 };
		System.out.println("Test 3: " + Arrays.toString(solution.solution(arr3))); // [7, 8, 9, 7]
	}

	public int[] solution(int[] arr) {
		// 결과를 저장할 배열
		int[] answer;

		// 스택을 생성 (스택을 이용해 중복된 숫자를 제거할 것임)
		Stack<Integer> st = new Stack<>();

		// 배열의 첫 번째 값은 스택에 넣음
		if (arr.length > 0) {
			st.add(arr[0]);
		}

		// 배열을 순차적으로 탐색하며 스택의 가장 위 값과 비교
		for (int i = 1; i < arr.length; i++) {
			// 스택의 가장 위 값과 현재 값이 다르면 스택에 추가
			if (st.peek() != arr[i])
				st.push(arr[i]);
		}

		// 스택의 크기만큼 answer 배열 생성
		answer = new int[st.size()];

		// 스택의 값을 하나씩 꺼내어 answer 배열에 저장 (스택의 순서가 반대이므로 역순으로 넣음)
		for (int i = st.size() - 1; i >= 0; i--) {
			answer[i] = st.pop();
		}

		// 결과 배열 반환
		return answer;
	}
}