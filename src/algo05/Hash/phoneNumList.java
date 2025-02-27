package algo05.Hash;

import java.util.HashMap;

public class phoneNumList {
    public static void main(String[] args) {
        // 테스트 케이스
        String[] phoneBook1 = {"119", "97674223", "1195524421"};
        String[] phoneBook2 = {"123", "456", "789"};
        String[] phoneBook3 = {"12", "123", "1235", "567", "88"};
        
        Solution solution = new Solution();
        
        System.out.println("결과: " + solution.solution(phoneBook1)); // 예상 출력: false
        System.out.println("결과: " + solution.solution(phoneBook2)); // 예상 출력: true
        System.out.println("결과: " + solution.solution(phoneBook3)); // 예상 출력: false
    }
    
    static class Solution { 
    	// 프로그래머스 전화번호 목록 문제
    	
        public boolean solution(String[] phone_book) {
            HashMap<String, Integer> map = new HashMap<>();
            
            for (String phone : phone_book) {
                map.put(phone, 1);
            }
            
            for (String phone : phone_book) {
                for (int i = 1; i < phone.length(); i++) {
                    if (map.containsKey(phone.substring(0, i))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
