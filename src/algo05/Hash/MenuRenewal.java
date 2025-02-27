package algo05.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class MenuRenewal {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 테스트 데이터 추가
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };

		// 결과 출력
		System.out.println("추천 메뉴 조합: " + solution.solution(orders, course));
	}

	static class Solution {
		// 프로그래머스 메뉴 리뉴얼 문제

		static HashMap<String, Integer> map;

		// 조합을 구하는 메소드
		public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
			if (cnt == n) {
				map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
				return;
			}

			for (int i = idx; i < str.length(); i++) {
				sb.append(str.charAt(i));
				combi(str, sb, i + 1, cnt + 1, n);
				sb.delete(cnt, cnt + 1);
			}
		}

		public ArrayList<String> solution(String[] orders, int[] course) {
			ArrayList<String> answer = new ArrayList<>();

			// 주문 문자열 정렬
			for (int i = 0; i < orders.length; i++) {
				char[] charArr = orders[i].toCharArray();
				Arrays.sort(charArr);
				orders[i] = String.valueOf(charArr);
			}

			// 코스 개수별 조합 찾기
			for (int i = 0; i < course.length; i++) {
				map = new HashMap<>();
				int max = Integer.MIN_VALUE;

				for (int j = 0; j < orders.length; j++) {
					StringBuilder sb = new StringBuilder();
					if (course[i] <= orders[j].length()) {
						combi(orders[j], sb, 0, 0, course[i]);
					}
				}

				// 가장 많이 주문된 조합 찾기
				for (Entry<String, Integer> entry : map.entrySet()) {
					max = Math.max(max, entry.getValue());
				}

				// 최소 2번 이상 주문된 조합 추가
				for (Entry<String, Integer> entry : map.entrySet()) {
					if (max >= 2 && entry.getValue() == max) {
						answer.add(entry.getKey());
					}
				}
			}

			// 결과 정렬
			Collections.sort(answer);
			return answer;
		}
	}

}
