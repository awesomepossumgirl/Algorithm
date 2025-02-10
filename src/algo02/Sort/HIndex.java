package algo02.Sort;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		// 테스트 데이터
		int[] citations1 = { 3, 0, 6, 1, 5 }; // 예상 결과: 3
		int[] citations2 = { 10, 8, 5, 4, 3 }; // 예상 결과: 4
		int[] citations3 = { 25, 8, 5, 3, 3 }; // 예상 결과: 3
		int[] citations4 = { 0, 0, 0, 0, 0 }; // 예상 결과: 0
		int[] citations5 = { 6, 6, 6, 6, 6 }; // 예상 결과: 5

		// solution 메서드 실행
		HIndex solution = new HIndex();

		System.out.println(solution.solution(citations1)); // 3
		System.out.println(solution.solution(citations2)); // 4
		System.out.println(solution.solution(citations3)); // 3
		System.out.println(solution.solution(citations4)); // 0
		System.out.println(solution.solution(citations5)); // 5
	}

	public int solution(int[] citations) {
		// 프로그래머스 H-INDEX
		// 결과값 담을 정수형 변수 초기화
		int answer = 0;

		// 배열 오름차순 정렬
		Arrays.sort(citations);

		// 배열 순회하여 H-Index 찾기
		for (int i = 0; i < citations.length; i++) {
			// 남은 논문의 수
			int h = citations.length - i;

			// 현재 인용된 논문 수가 h 이상이면 H-Index 갱신
			if (citations[i] >= h) {
				answer = h;
				break;
			}
		}
		return answer;
	}
}