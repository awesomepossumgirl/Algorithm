package algo02.Sort;

import java.util.Arrays;

public class KthNumber {

	public static void main(String[] args) {
		// 테스트 데이터
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, // array[1:5] → {5,2,6,3} → 정렬 후 {2,3,5,6} → 3번째 숫자는 5
				{ 4, 4, 1 }, // array[3:4] → {6} → 정렬 후 {6} → 1번째 숫자는 6
				{ 1, 7, 3 } // array[0:7] → {1,5,2,6,3,7,4} → 정렬 후 {1,2,3,4,5,6,7} → 3번째 숫자는 3
		};

		// solution 메서드 실행
		KthNumber solution = new KthNumber();
		int[] result = solution.solution(array, commands);

		// 결과 출력
		System.out.println(Arrays.toString(result)); // [5, 6, 3]
	}

	public int[] solution(int[] array, int[][] commands) {
		// 프로그래머스 K번째 수
		// 1. 결과값 담아줄 정수형 배열 result 선언
		int[] result = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			// 2. array 배열 돌면서 각 commands 요소의
			// i번째숫자, j번째숫자를 인자로 슬라이싱
			// 슬라이싱한 배열을 slicedArray에 담아줌
			int[] slicedArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

			// 3. 자른 배열 오름차순 정렬
			Arrays.sort(slicedArray);
			// 4. result에 slicedArray의 k번째 숫자 집어 넣기
			result[i] = slicedArray[commands[i][2] - 1];
		}
		return result;
	}
}