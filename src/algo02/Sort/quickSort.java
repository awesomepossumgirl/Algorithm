package algo02.Sort;

import java.util.Arrays;

public class quickSort {
	// 퀵 정렬 알고리즘 구현
	public static void quicksort(int[] arr, int low, int high) {
		if (low < high) { // 정렬할 요소가 2개 이상일 경우 실행
			int pivot = partition(arr, low, high); // 피벗을 기준으로 배열을 나눔
			quicksort(arr, low, pivot - 1); // 피벗 왼쪽 부분 정렬
			quicksort(arr, pivot + 1, high); // 피벗 오른쪽 부분 정렬
		}
	}

	// 배열을 분할하는 함수 (피벗을 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽으로 정렬)
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; // 마지막 요소를 피벗으로 설정
		int i = low - 1; // i는 작은 값들이 들어갈 위치를 가리킴

		for (int j = low; j < high; j++) { // low부터 high-1까지 반복
			if (arr[j] < pivot) { // 현재 요소가 피벗보다 작으면
				i++; // i 증가 후
				int temp = arr[i]; // arr[i]와 arr[j] 위치 변경
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// 피벗을 올바른 위치(i+1)로 이동
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1; // 피벗의 최종 위치 반환
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 9, 1, 5, 6 };
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}