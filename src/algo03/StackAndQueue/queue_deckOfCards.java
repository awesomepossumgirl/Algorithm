package algo03.StackAndQueue;

public class queue_deckOfCards {

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(
            new String[]{"a", "b", "c"}, 
            new String[]{"d", "e", "f"}, 
            new String[]{"a", "d", "b", "e", "c", "f"})); // Yes
        
        System.out.println(solution(
            new String[]{"a", "b", "c"}, 
            new String[]{"d", "e", "f"}, 
            new String[]{"a", "b", "d", "e", "c", "f"})); // No
    }
    
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
    	// 프로그래머스 카드 뭉치 문제
    	// https://school.programmers.co.kr/learn/courses/30/lessons/159994
    	
        int idx1 = 0; // cards1 배열의 인덱스
        int idx2 = 0; // cards2 배열의 인덱스
        
        // goal 배열 순회
        for (String currentStr : goal) {
            // currentStr이 cards1[idx1] 또는 cards2[idx2]에 포함하는지 확인
            if (idx1 < cards1.length && currentStr.equals(cards1[idx1])) {
                idx1++; // cards1[idx1]에 포함하는 경우 idx1 증가
            } else if (idx2 < cards2.length && currentStr.equals(cards2[idx2])) {
                idx2++; // cards2[idx2]에 포함하는 경우 idx2 증가
            } else {
                return "No"; // 둘 다 포함하지 않는 경우
            }
        }
        
        return "Yes";
    }
}
