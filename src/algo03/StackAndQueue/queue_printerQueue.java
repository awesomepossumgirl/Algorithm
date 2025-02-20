package algo03.StackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class queue_printerQueue {

	public static void main(String[] args) throws IOException {
		// 입력을 받기 위한 BufferedReader와 출력용 StringBuilder 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		// 테스트 케이스마다 처리
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N: 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // M: 목표 문서의 인덱스

			int[] priorities = new int[N]; // 문서의 우선순위를 저장할 배열
			st = new StringTokenizer(br.readLine());
			// 문서들의 우선순위를 입력받음
			for (int i = 0; i < N; i++) {
				priorities[i] = Integer.parseInt(st.nextToken()); // 우선순위 입력
			}

			// solution 메서드를 호출하고 결과를 StringBuilder에 추가
			sb.append(solution(N, M, priorities)).append('\n');
		}

		// 모든 결과를 한 번에 출력
		System.out.println(sb);

		// 추가 테스트 케이스
		System.out.println(solution(6, 0, new int[] { 1, 1, 9, 1, 1, 1 })); // 5
		System.out.println(solution(4, 2, new int[] { 1, 2, 3, 4 })); // 2
	}

	public static int solution(int N, int M, int[] priorities) {
		// 백준 1966번 프린터큐 
		// https://www.acmicpc.net/problem/1966
		
		// 문서들의 인덱스와 우선순위를 저장할 큐
		LinkedList<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q.offer(new int[] { i, priorities[i] }); // 문서의 인덱스와 우선순위를 큐에 추가
		}

		int count = 0; // 출력된 문서의 개수를 세는 변수
		while (!q.isEmpty()) {
			// 큐에서 첫 번째 문서를 꺼냄
			int[] front = q.poll();
			boolean isMax = true; // 현재 문서가 가장 우선순위가 높은지 확인하는 플래그

			// 큐 안에 다른 문서들 중 더 높은 우선순위를 가진 문서가 있는지 확인
			for (int i = 0; i < q.size(); i++) {
				if (front[1] < q.get(i)[1]) { // 만약 더 높은 우선순위의 문서가 있다면
					q.offer(front); // 현재 문서를 큐의 뒤로 다시 넣음
					// 큐의 앞에 있는 문서들을 뒤로 재배치
					for (int j = 0; j < i; j++) {
						q.offer(q.poll());
					}
					isMax = false; // 현재 문서는 가장 우선순위가 아님
					break;
				}
			}

			// 만약 현재 문서가 가장 우선순위가 아니라면, 다시 반복
			if (!isMax)
				continue;

			count++; // 문서가 출력되었으므로 출력된 문서의 수 증가
			// 목표 문서가 출력되었다면 출력된 문서의 수를 반환
			if (front[0] == M) {
				return count;
			}
		}
		return count; // 모든 문서가 출력될 때까지 목표 문서가 출력되지 않으면 출력된 문서의 수 반환
	}
}
