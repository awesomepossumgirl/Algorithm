package algo01.Greedy;

import java.util.Arrays;

public class Sportswear {

	public static void main(String[] args) {
		Sportswear sw = new Sportswear();

		int n1 = 5;
		int[] lost1 = { 2, 4 };
		int[] reserve1 = { 1, 3, 5 };
		System.out.println(sw.solution(n1, lost1, reserve1)); // Expected output: 5

		int n2 = 5;
		int[] lost2 = { 2, 4 };
		int[] reserve2 = { 3 };
		System.out.println(sw.solution(n2, lost2, reserve2)); // Expected output: 4

		int n3 = 3;
		int[] lost3 = { 3 };
		int[] reserve3 = { 1 };
		System.out.println(sw.solution(n3, lost3, reserve3)); // Expected output: 2
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		Arrays.sort(lost);
		Arrays.sort(reserve);

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					answer++;
					lost[i] = -1;
					reserve[j] = -1;
					break;
				}
			}
		}

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
					answer++;
					reserve[j] = -1;
					break;
				}
			}
		}
		return answer;
	}
}