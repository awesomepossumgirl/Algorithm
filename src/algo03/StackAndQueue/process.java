package algo03.StackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;

public class process {

    public static void main(String[] args) {
        // 프로그래머스 프로세스 문제
        process solution = new process();  // Create instance of Process class

        // 테스트 1
        int[] priorities1 = { 2, 1, 3, 2 };
        int location1 = 2;
        System.out.println("Test 1: " + solution.solution(priorities1, location1));
        // 1 (3이 가장 높은 우선순위, 2번째 위치의 3이 가장 먼저 출력)

        // 테스트 2
        int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
        int location2 = 0;
        System.out.println("Test 2: " + solution.solution(priorities2, location2));
        // 5 (9가 우선순위가 가장 높아서, 9는 3번째로 출력되며 0번 위치는 마지막에 처리)

        // 테스트 3
        int[] priorities3 = { 4, 3, 2, 1 };
        int location3 = 3;
        System.out.println("Test 3: " + solution.solution(priorities3, location3));
        // 4 (각각의 우선순위가 내림차순이므로, 1번 프로세스가 마지막에 처리)

    }

    public int solution(int[] priorities, int location) {

        // 큐에 인덱스를 함께 저장하여 처리할 수 있도록 LinkedList 사용
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // 큐에 인덱스와 우선순위 삽입
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            priorityQueue.offer(priorities[i]);
        }

        int cnt = 0;

        // 큐가 비어있지 않으면 계속 처리
        while (!queue.isEmpty()) {
            // 큐에서 인덱스를 하나 꺼내서 해당 프로세스의 우선순위를 확인
            int idx = queue.poll();

            // 만약 현재 프로세스의 우선순위가 가장 높다면 처리
            if (priorities[idx] == priorityQueue.peek()) {
                priorityQueue.poll(); // 해당 우선순위 제거
                cnt++; // 처리된 순서 증가

                // 처리한 프로세스가 원하는 프로세스라면 결과 반환
                if (idx == location) {
                    return cnt;
                }
            } else {
                // 우선순위가 더 높은 프로세스가 있는 경우 맨 뒤로 재배치
                queue.offer(idx);
            }
        }

        return cnt;
    }
}
