package algo05.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class OpenChat {

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 테스트 케이스
        String[] record = {
            "Enter uid1234 지훈",
            "Enter uid4567 민서",
            "Leave uid1234",
            "Enter uid1234 서준",
            "Change uid4567 윤아"
        };
        
        String[] result = solution.solution(record);
        System.out.println(Arrays.toString(result));
    }
 
    static class Solution {
    	// 프로그래머스 오픈채팅방 문제
    	
        public String[] solution(String[] record) {
            Map<String, String> infoMap = new HashMap<>(); // (id-nickname) Map
            int count = 0;
            
            for (int i = 0; i < record.length; i++) {
                String[] data = record[i].split(" ");
     
                if (data[0].equals("Leave")) { // 퇴장
                    continue;
                } else if (data[0].equals("Enter")) { // 입장
                    infoMap.put(data[1], data[2]);
                } else { // 닉네임 변경
                    infoMap.put(data[1], data[2]);
                    count++;
                }
            }
            
            String[] answer = new String[record.length - count];
            int idx = 0;
            
            for (int i = 0; i < record.length; i++) {
                String[] data = record[i].split(" ");
                String nickname = infoMap.get(data[1]);
                
                if (data[0].equals("Enter")) { // 입장 메시지
                    answer[idx++] = nickname + "님이 들어왔습니다.";
                } else if (data[0].equals("Leave")) { // 퇴장 메시지
                    answer[idx++] = nickname + "님이 나갔습니다.";
                }
            }
            return answer;
        }
    }
}
