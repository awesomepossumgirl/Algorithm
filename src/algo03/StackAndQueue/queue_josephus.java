package algo03.StackAndQueue;

import java.util.LinkedList;
import java.util.Scanner;

public class queue_josephus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		in.close();

		System.out.println(solution(N, K));

		// 테스트 케이스
		System.out.println(solution(7, 3)); // <3, 6, 2, 7, 5, 1, 4>
		System.out.println(solution(5, 2)); // <2, 4, 1, 5, 3>
	}

	public static String solution(int N, int K) {
		// 백준 1158번 요세푸스
		// https://www.acmicpc.net/problem/1158
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append('<');

		int index = 0;
		while (list.size() > 1) {
			index = (index + (K - 1)) % list.size();
			sb.append(list.remove(index)).append(", ");
		}

		sb.append(list.remove()).append('>');
		return sb.toString();
	}
}
