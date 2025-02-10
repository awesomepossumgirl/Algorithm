package algo02.Sort;

import java.util.Arrays;

public class selectionSort {

	// 선택 정렬 알고리즘 구현
    public static void selectionsort(int[] arr) {
        int n = arr.length;

        // 배열을 반복하면서 최소값을 찾음
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // 현재 반복에서 최소값을 가진 인덱스

            // 현재 인덱스 이후의 요소들과 비교하여 최솟값 찾기
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) { // 더 작은 값이 있으면 minIdx 갱신
                    minIdx = j;
                }
            }

            // 최솟값과 현재 위치의 요소를 교환 (Swap)
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

}