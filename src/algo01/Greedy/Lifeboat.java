package algo01.Greedy;

import java.util.Arrays;

public class Lifeboat {
	public static void main(String[] args) {
		Lifeboat lifeboat = new Lifeboat();

		int[] people1 = { 70, 50, 80, 50 };
		int limit1 = 100;
		System.out.println(lifeboat.solution(people1, limit1)); // Expected output: 3

		int[] people2 = { 70, 80, 50 };
		int limit2 = 100;
		System.out.println(lifeboat.solution(people2, limit2)); // Expected output: 3
	}

	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		int idx = 0; // 가장 가벼운 사람의 인덱스
		int answer = 0; // 필요한 구명보트 수

		for (int i = people.length - 1; i >= idx; i--) {
			if (people[i] + people[idx] <= limit) {
				idx++; // 가장 가벼운 사람도 태움
			}
			answer++; // 보트 사용
		}

		return answer;
	}
}