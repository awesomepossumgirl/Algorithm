package algo03.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class queue_truckCrossingtheBridge {

	public static void main(String[] args) {
		// 프로그래머스 다리를 지나는 트럭 문제
		queue_truckCrossingtheBridge solution = new queue_truckCrossingtheBridge();

        // 테스트 1
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7, 4, 5, 6};
        System.out.println("Test 1: " + solution.solution(bridge_length1, weight1, truck_weights1));
        // 8

        // 테스트 2
        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println("Test 2: " + solution.solution(bridge_length2, weight2, truck_weights2));
        // 110

        // 테스트 3
        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10, 20, 30, 40, 50};
        System.out.println("Test 3: " + solution.solution(bridge_length3, weight3, truck_weights3));
        // 310
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		// 다리 길이만큼 큐 선언
		Queue<Integer> bridge = new LinkedList<>();
		// 걸리는 총 시간
		int time = 0;
		// 현재 다리 위의 무게
		int currentWeight = 0;

		for (int i = 0; i < bridge_length; i++) {
			bridge.add(0);
		}
		// 현재 다리에 오를 트럭의 인덱스
		int index = 0;

		// 아직 다리에 올라가지 않은 트럭이 남아있는지
		// 현재 다리 위에 트럭이 남아있는지
		while (index < truck_weights.length || currentWeight > 0) {
			time++;

			// 다리의 맨 앞 트럭이 나감
			int leftTruck = bridge.poll();
			currentWeight -= leftTruck;

			// 다음 트럭이 다리에 진입할 수 있는지 조건 확인
			if (index < truck_weights.length) {
				if (currentWeight + truck_weights[index] <= weight) {
					// 트럭이 다리에 진입
					bridge.add(truck_weights[index]);
					currentWeight += truck_weights[index];
					index++;
				} else {
					// 트럭이 다리에 진입 할 수 없으면 빈 공간 추가
					bridge.add(0);
				}
			} else {
				// 트럭이 다리에 진입할 수 없으면 빈 공간 추가
				bridge.add(0);
			}
		}
		return time;
	}

}
