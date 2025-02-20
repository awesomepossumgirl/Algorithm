package algo03.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class queue_josephus {

    public static void main(String[] args) {
        System.out.println(solution(5, 2)); // 결과: 3
    }

    /**
     * 요세푸스 문제를 해결하는 함수
     * 
     * @param N 사람의 수 (1부터 N까지 번호가 있음)
     * @param K 제거할 순번 (K번째 사람을 계속 제거함)
     * @return 마지막에 살아남은 사람의 번호
     */
    public static int solution(int N, int K) {
        // 큐(Queue) 생성: 원형 구조를 시뮬레이션하기 위해 사용
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지의 사람을 큐에 추가
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 마지막 한 명이 남을 때까지 반복
        while (queue.size() > 1) {
            // K번째 사람을 제거하기 위해 K-1번 앞의 사람을 뒤로 보냄
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll()); // 맨 앞 사람을 빼서 큐의 뒤에 추가
            }
            queue.poll(); // K번째 사람 제거
        }

        // 마지막 남은 사람 반환
        return queue.poll();
    }
}
