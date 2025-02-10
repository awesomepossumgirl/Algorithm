package algo02.Sort;

import java.util.Arrays; // import 문을 올바른 위치로 이동

public class mergeSort {

    // 병합 정렬 알고리즘 구현(재귀적 분할)
    public static void mergesort(int[] arr, int left, int right) {
        if (left < right) { // 배열의 크기가 1보다 크다면 수행
            int mid = (left + right) / 2; // 중간 지점 계산
            mergesort(arr, left, mid); // 왼쪽 부분 배열 정렬
            mergesort(arr, mid + 1, right); // 오른쪽 부분 배열 정렬
            merge(arr, left, mid, right); // 정렬된 두 부분을 병합
        }
    }

    // 두 개의 정렬된 배열을 병합하는 함수
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // 왼쪽 배열 크기
        int n2 = right - mid; // 오른쪽 배열 크기

        int[] leftArr = new int[n1]; // 왼쪽 배열 생성
        int[] rightArr = new int[n2]; // 오른쪽 배열 생성

        // 원본 배열에서 데이터 복사
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left; // i: 왼쪽 배열 인덱스, j: 오른쪽 배열 인덱스, k: 원본 배열 인덱스

        // 두 배열을 비교하며 병합
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) { // 왼쪽 배열 값이 작거나 같으면
                arr[k++] = leftArr[i++]; // 왼쪽 값 추가 후 인덱스 증가
            } else { // 오른쪽 배열 값이 작으면
                arr[k++] = rightArr[j++]; // 오른쪽 값 추가 후 인덱스 증가
            }
        }

        // 왼쪽 배열에 남은 요소 추가
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // 오른쪽 배열에 남은 요소 추가
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        mergesort(arr, 0, arr.length - 1); 
        System.out.println(Arrays.toString(arr));
    }
}