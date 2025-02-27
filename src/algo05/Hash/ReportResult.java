package algo05.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ReportResult {

    public static void main(String[] args) {
        // 테스트 데이터
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        
        // Solution 객체 생성 및 결과 출력
        Solution solution = new Solution();
        int[] result = solution.solution(idList, report, k);
        
        // 결과 출력
        System.out.println("각 이용자가 받은 신고 처리 결과 메일 개수: " + Arrays.toString(result));
    }

    static class Solution {
        // 프로그래머스 신고 결과 받기 문제 
    	
        public int[] solution(String[] idList, String[] report, int k) {
            // @param idList : 이용자의 ID를 담은 배열.
            // @param report : 신고한 이용자와 신고당한 이용자의 정보를 담은 배열. ex) "a b",.. -> a가 b를 신고
            // @param k : 신고 횟수에 따른 정지 기준 정수값.
            // @return answer : id_list에 담긴 id 순서대로 각 유저가 받은 신고 결과 메일 개수 배열.
            
            int[] answer = new int[idList.length];
            HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>(); // 신고한 사람 -> 신고당한 사람 목록
            HashMap<String, Integer> reportedCountInfoMap = new HashMap<>(); // 신고당한 사람 -> 신고 횟수
            HashSet<String> reportSet = new HashSet<>(Arrays.asList(report)); // 중복 신고 제거
            
            // 신고 정보 기록
            for (String reportInfo : reportSet) {
                String[] split = reportInfo.split(" ");
                String reporter = split[0]; // 신고 한 사람
                String reported = split[1]; // 신고 당한 사람
                
                // 신고한 사람 정보를 해시맵에 저장
                reporterInfoMap.putIfAbsent(reporter, new HashSet<>());
                reporterInfoMap.get(reporter).add(reported);
                
                // 신고당한 사람의 신고 횟수 증가
                reportedCountInfoMap.put(reported, reportedCountInfoMap.getOrDefault(reported, 0) + 1);
            }
            
            // 정지 대상자 확인 및 메일 발송 개수 계산
            for (String reported : reportedCountInfoMap.keySet()) {
                if (reportedCountInfoMap.get(reported) >= k) { // 신고 횟수가 기준 k 이상일 경우
                    for (int i = 0; i < idList.length; i++) {
                        if (reporterInfoMap.containsKey(idList[i]) && reporterInfoMap.get(idList[i]).contains(reported)) {
                            answer[i]++; // 신고한 사람에게 메일 발송
                        }
                    }
                }
            }
            
            return answer;
        }
    }
}