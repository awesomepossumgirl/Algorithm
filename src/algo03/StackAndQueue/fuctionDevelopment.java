package algo03.StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class fuctionDevelopment {

	public static void main(String[] args) {
		// 프로그래머스 기능개발 문제

		Solution solution = new Solution();

		// 테스트 1
		int[] progresses1 = { 93, 30, 55 };
		int[] speeds1 = { 1, 30, 5 };
		System.out.println("Test 1: " + Arrays.toString(solution.solution(progresses1, speeds1)));
		// [2, 1]

		// 테스트 2
		int[] progresses2 = { 95, 90, 99, 99, 80, 99 };
		int[] speeds2 = { 1, 1, 1, 1, 1, 1 };
		System.out.println("Test 2: " + Arrays.toString(solution.solution(progresses2, speeds2)));
		// [1, 3, 2]
	}
}

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {

		// 결과를 저장할 ArrayList 생성
		ArrayList<Integer> answer = new ArrayList<>();

		// 각 작업의 완료일을 저장할 Queue 생성
		Queue<Integer> workDays = new LinkedList<>();

		// 각 작업별 완료까지 남은 일수를 계산하여 Queue에 저장
		for (int i = 0; i < progresses.length; i++) {
			// 진행률과 속도를 고려하여 남은 일수를 계산
			int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
			workDays.add(days); // 남은 일수를 Queue에 추가
		}

		// 작업 완료일을 처리하며 배포할 기능 개수 계산
		while (!workDays.isEmpty()) {
			// 첫 번째 작업의 완료일을 가져옴
			int currentMax = workDays.poll();
			int cnt = 1; // 첫 번째 작업은 기본적으로 하나씩 배포됨

			// 그 다음 작업이 첫 번째 작업과 같은 기간 내에 완료된다면
			// 그 작업들도 함께 배포함
			while (!workDays.isEmpty() && workDays.peek() <= currentMax) {
				workDays.poll(); // 해당 작업을 배포 목록에서 제거
				cnt++; // 배포된 작업의 개수 증가
			}

			// 배포된 작업 개수를 answer에 추가
			answer.add(cnt);
		}

		// ArrayList를 int 배열로 변환하여 반환
		return answer.stream().mapToInt(i -> i).toArray();
	}

}
