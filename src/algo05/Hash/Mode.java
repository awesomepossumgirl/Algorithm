package algo05.Hash;

import java.util.HashMap;
import java.util.Map;

public class Mode {

	public static void main(String[] args) {
		// 테스트 데이터 실행
		int[][] testArrays = { { 1, 2, 3, 3, 3, 4 }, // Expected result: 3
				{ 1, 1, 2, 2 }, // Expected result: -1
				{ 1 } // Expected result: 1
		};

		for (int[] testArray : testArrays) {
			System.out.println("Result: " + solution(testArray));
		}
	}

	static int solution(int[] array) {
		// 프로그래머스 최빈값 구하기 문제
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		int maxCount = 0;
		int mode = -1;
		boolean isDuplicate = false;

		// 각 숫자의 등장 횟수 저장하기
		for (int num : array) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}
		
		/*
		 * if (frequencyMap.containsKey(num)) { frequencyMap.put(num,
		 * frequencyMap.get(num) + 1); } else { frequencyMap.put(num, 1); }
		 */
		

		// 최빈값 찾기
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			int key = entry.getKey();
			int count = entry.getValue();

			if (count > maxCount) {
				maxCount = count;
				mode = key;
				isDuplicate = false; // 새로운 최빈값 나오면 중복 해제
			} else if (count == maxCount) {
				isDuplicate = true; // 최빈값이 여러개인 경우
			}
		}
		return isDuplicate ? -1 : mode;
	}
}
