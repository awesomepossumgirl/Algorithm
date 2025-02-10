package algo02.Sort;

import java.util.Arrays;

public class heapSort {
	// 힙정렬 알고리즘 구현
	public static void heapsort(int[] arr) {
		int n = arr.length;

		// 1. 주어진 배열을 최대 힙(Max Heap)으로 변환
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// 2. 힙에서 요소를 하나씩 꺼내 정렬
		for (int i = n - 1; i > 0; i--) {
			// 최대 힙의 루트(최댓값)를 마지막 요소와 교환
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// 힙 크기를 줄이고 다시 힙 성질을 유지하도록 heapify 호출
			heapify(arr, i, 0);
		}
	}

	// 힙 성질을 유지하는 함수 (heapify)
	private static void heapify(int[] arr, int n, int i) {
		int largest = i; // 부모 노드
		int left = 2 * i + 1; // 왼쪽 자식
		int right = 2 * i + 2; // 오른쪽 자식

		// 왼쪽 자식이 더 크면 largest 업데이트
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		// 오른쪽 자식이 더 크면 largest 업데이트
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		// largest가 부모 노드가 아니면 스왑 후 다시 heapify 호출
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 9, 1, 5, 6 };
		System.out.println("정렬 전: " + Arrays.toString(arr));
		heapsort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}
}