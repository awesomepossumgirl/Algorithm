package algo01.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {

    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(new Camera().solution(routes)); // 결과: 2
    }

    public int solution(int[][] routes) {
        // 카메라를 설치한 횟수
        int cameraCount = 0;

        // 이동 경로 종료 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return Integer.compare(route1[1], route2[1]); // 더 안전한 비교 방식
            }
        });

        // 설치된 카메라가 감시할 수 있는 마지막 위치
        int lastCameraPosition = Integer.MIN_VALUE;

        // 모든 차량의 경로를 순회하면서 카메라가 필요한 구간 찾기
        for (int[] route : routes) {
            if (lastCameraPosition < route[0]) { // 새로운 카메라 필요
                lastCameraPosition = route[1]; // 카메라를 현재 차량의 끝 지점에 설치
                cameraCount++; // 카메라 개수 증가
            }
        }

        return cameraCount; // 최종 카메라 개수 반환
    }
}