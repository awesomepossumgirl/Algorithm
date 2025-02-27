package algo05.Hash;

import java.util.HashMap;

public class IncompleteFinisher {
    public static void main(String[] args) {
        // 테스트 케이스
        String[] participant1 = {"홍길동", "김철수", "이영희"};
        String[] completion1 = {"김철수", "이영희"};
        
        String[] participant2 = {"박지성", "손흥민", "차범근", "박지성"};
        String[] completion2 = {"박지성", "손흥민", "차범근"};
        
        Solution solution = new Solution();
        
        System.out.println("완주하지 못한 선수: " + solution.solution(participant1, completion1)); // 예상 출력: 홍길동
        System.out.println("완주하지 못한 선수: " + solution.solution(participant2, completion2)); // 예상 출력: 박지성
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
    	// 프로그래머스 완주하지 못한 선수 문제
    	
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 참가자 배열로 해시맵을 구성
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);  // 참가자 이름을 키로, 카운트를 값으로 저장
        }
        
        // 2. 완주자 배열을 순회하면서 해시맵에서 값을 감소
        for (String c : completion) {
            map.put(c, map.get(c) - 1);  // 완주자에 해당하는 이름의 값을 1씩 감소
        }
        
        // 3. 값이 0이 아닌 키가 완주하지 못한 참가자
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;  // 값이 0이 아닌 참가자 이름을 반환
            }
        }
        
        return "";  // 조건에 맞는 참가자를 찾지 못할 경우(일반적으로는 발생하지 않음)
    }
}