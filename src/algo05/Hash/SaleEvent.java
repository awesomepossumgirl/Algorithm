package algo05.Hash;

import java.util.HashMap;

public class SaleEvent {

	public static void main(String[] args) {
		// 테스트 데이터 추가
		String[] want = { "사과", "바나나", "쌀", "돼지고기", "냄비" };
		int[] number = { 1, 2, 1, 2, 1 };
		String[] discount = { "바나나", "사과", "쌀", "사과", "바나나", "돼지고기", "쌀", "돼지고기", "냄비", "바나나", "사과", "쌀", "사과", "바나나",
				"돼지고기", "쌀", "돼지고기", "냄비", "바나나", "사과" };

		// Solution 객체 생성 및 메서드 호출
		Solution solution = new Solution();
		int result = solution.solution(want, number, discount);

		// 결과 출력
		System.out.println("가능한 할인 행사 시작일의 개수: " + result);
	}

	static class Solution {
		// 프로그래머스 할인 행사 문제
		public int solution(String[] want, int[] number, String[] discount) {
			int answer = 0;

			HashMap<String, Integer> map = new HashMap<>();
			// 원하는 제품과 개수를 해시맵에 저장
			for (int i = 0; i < want.length; i++) {
				map.put(want[i], number[i]);
			}

			// 첫 10일 동안의 할인 품목 체크
			for (int i = 0; i < 10; i++) {
				if (map.containsKey(discount[i])) {
					map.put(discount[i], map.get(discount[i]) - 1);
				}
			}

			// 첫 10일이 조건을 만족하는지 확인
			if (isMatch(map)) {
				answer++;
			}

			// 슬라이딩 윈도우 기법 적용 (10일 단위 이동)
			for (int i = 10; i < discount.length; i++) {
				// 윈도우에서 제외되는 요소 복구
				if (map.containsKey(discount[i - 10])) {
					map.put(discount[i - 10], map.get(discount[i - 10]) + 1);
				}
				// 윈도우에 새로 포함되는 요소 반영
				if (map.containsKey(discount[i])) {
					map.put(discount[i], map.get(discount[i]) - 1);
				}

				// 조건이 만족하는지 확인
				if (isMatch(map)) {
					answer++;
				}
			}

			return answer;
		}

		// 해시맵의 모든 값이 0이면 true 반환 (조건 충족 확인)
		public boolean isMatch(HashMap<String, Integer> map) {
			for (String key : map.keySet()) {
				if (map.get(key) != 0) {
					return false;
				}
			}
			return true;
		}
	}
}
