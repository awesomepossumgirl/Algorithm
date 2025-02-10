package algo02.Sort;

import java.util.Arrays;

public class insertionSort {
	// 삽입 정렬 알고리즘 구현
	public static void insertionsort(int[] arr) {
		int n = arr.length; // 배열의 길이 저장
		for (int i = 1; i < n; i++) { // 두 번째 요소부터 반복 시작
			int key = arr[i]; // 현재 삽입할 값을 저장
			int j = i - 1; // 이전 요소의 인덱스

			// key보다 큰 요소들을 오른쪽으로 이동
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j]; // 값을 한 칸 오른쪽으로 이동
				j--; // 다음 비교를 위해 인덱스 감소
			}
			arr[j + 1] = key; // 적절한 위치에 key 삽입
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 9, 1, 5, 6 };
		insertionsort(arr);
		System.out.println(Arrays.toString(arr));
	}
}