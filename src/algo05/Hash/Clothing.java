package algo05.Hash;

import java.util.HashMap;

public class Clothing {
    public static void main(String[] args) {
        // 테스트 케이스 1: 모자(Headgear) 2개, 안경(Eyewear) 1개
        String[][] clothes1 = {{"노란 모자", "모자"}, {"파란 선글라스", "안경"}, {"초록 터번", "모자"}};
        
        // 테스트 케이스 2: 얼굴(Face) 장식 3개
        String[][] clothes2 = {{"까마귀 가면", "얼굴"}, {"파란 선글라스", "얼굴"}, {"스모키 메이크업", "얼굴"}};
        
        // 테스트 케이스 3: 모자 2개, 상의 1개, 하의 1개
        String[][] clothes3 = {{"모자1", "모자"}, {"모자2", "모자"}, {"셔츠", "상의"}, {"바지", "하의"}};
        
        Solution solution = new Solution();
        
        // 각 테스트 케이스 실행 및 결과 출력
        System.out.println("결과: " + solution.solution(clothes1)); // 예상 출력: 5
        System.out.println("결과: " + solution.solution(clothes2)); // 예상 출력: 3
        System.out.println("결과: " + solution.solution(clothes3)); // 예상 출력: 11
    }

    static class Solution {
    	// 프로그래머스 의상 문제
    	
        public int solution(String[][] clothes) {
            // 1. 의상의 종류별 개수를 저장할 HashMap 생성
            HashMap<String, Integer> map = new HashMap<>();
            
            // 2. 모든 의상을 순회하며 의상 종류별 개수를 저장
            for (String[] clothe : clothes) {
                String type = clothe[1]; // 의상의 종류 가져오기
                map.put(type, map.getOrDefault(type, 0) + 1); // 기존 값이 없으면 0, 있으면 +1 증가
            }
            
            // 3. 의상 조합 계산을 위한 변수 선언 (초기값 1)
            int result = 1;
            
            // 4. 각 의상 종류별 개수에 +1(선택 안 하는 경우 포함)을 곱하여 경우의 수 계산
            for (int count : map.values()) {
                result *= (count + 1);
            }
            
            // 5. 아무것도 입지 않은 경우(1가지) 제외 후 반환
            return result - 1;
        }
    }
}
