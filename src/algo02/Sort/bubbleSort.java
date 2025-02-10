package algo02.Sort;

import java.util.Arrays;

public class bubbleSort {
	
	// 버블 정렬 알고리즘 구현
    public static void bubblesort(int[] arr) {
        int n = arr.length; // 배열의 길이를 구함
        // 배열의 모든 요소에 대해 순차적으로 비교
        for (int i = 0; i < n - 1; i++) {
            // 정렬되지 않은 부분에 대해 비교하여 큰 값을 뒤로 보냄
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { // 오름차순 정렬 조건
                    // arr[j]와 arr[j + 1]을 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
    	 int[] arr = {5, 2, 9, 1, 5, 6};
         bubblesort(arr);
         System.out.println(Arrays.toString(arr));
    }
}