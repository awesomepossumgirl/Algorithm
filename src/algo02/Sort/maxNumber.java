package algo02.Sort;

import java.util.Arrays;

public class maxNumber {

	public static void main(String[] args) {
		// 테스트 데이터
		String[] arr1 = { "3", "30", "34", "5", "9" };
		String[] arr2 = { "10", "2" };
		String[] arr3 = { "0", "0", "0" }; // 예외 케이스: "000" → "0"으로 처리 필요
		String[] arr4 = { "1", "20", "23", "4", "8" };

		// 테스트 실행
		System.out.println(getLargestNumber(arr1)); // 9534330
		System.out.println(getLargestNumber(arr2)); // 210
		System.out.println(getLargestNumber(arr3)); // 0
		System.out.println(getLargestNumber(arr4)); // 8423201
	}

	public static String getLargestNumber(String[] arr) {
		// 프로그래머스 가장 큰 수
		// 문자열 정렬 (내림차순, o2+o1과 o1+o2를 비교)
		Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		// 예외 처리: 배열이 "0"으로만 구성된 경우 → "0" 반환
		if (arr[0].equals("0"))
			return "0";

		// 정렬된 결과를 하나의 문자열로 결합
		StringBuilder result = new StringBuilder();
		for (String str : arr) {
			result.append(str);
		}

		return result.toString();
	}

}