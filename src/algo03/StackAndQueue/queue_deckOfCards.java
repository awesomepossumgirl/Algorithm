package algo03.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class queue_deckOfCards {

	public static void main(String[] args) {
		// 테스트 케이스
		System.out.println(solution(
				new String[] { "a", "b", "c" }, 
				new String[] { "d", "e", "f" },
				new String[] { "a", "d", "b", "e", "c", "f" })); // Yes

		System.out.println(solution(
				new String[] { "a", "b", "c" }, 
				new String[] { "d", "e", "f" },
				new String[] { "a", "b", "d", "e", "c", "f" })); // No
	}

	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		// 프로그래머스 카두 뭉치 문제

		Deque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
		Deque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));

		// goal 배열을 순회하면서 비교
		for (String target : goal) {
			if (!cardsDeque1.isEmpty() && cardsDeque1.peek().equals(target)) {
				cardsDeque1.poll();
			} else if (!cardsDeque2.isEmpty() && cardsDeque2.peek().equals(target)) {
				cardsDeque2.poll();
			} else {
				return "No";
			}
		}
		return "Yes"; // 모든 목표 문자열을 만들 수 있으면 성공

	}
}
