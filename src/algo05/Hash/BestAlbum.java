package algo05.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestAlbum {
    public static void main(String[] args) {
        // 테스트 케이스
        String[] genres1 = {"pop", "pop", "rock", "rock", "jazz"};
        int[] plays1 = {500, 600, 150, 800, 200};
        
        String[] genres2 = {"classic", "classic", "pop", "pop", "classic"};
        int[] plays2 = {400, 500, 600, 700, 800};
        
        Solution solution = new Solution();
        
        System.out.println("결과: " + Arrays.toString(solution.solution(genres1, plays1))); // 예상 출력: [3, 2, 1, 0]
        System.out.println("결과: " + Arrays.toString(solution.solution(genres2, plays2))); // 예상 출력: [4, 1, 3, 2]
    }
    static class Solution {
    	//프로그래머스 베스트 앨범 문제
    	
        public int[] solution(String[] genres, int[] plays) {
            
            // 1. 베스트앨범에 들어갈 노래의 인덱스를 저장할 리스트 생성
            ArrayList<Integer> album = new ArrayList<>();
            
            // 2. 장르별 총 재생 횟수를 저장할 HashMap 선언
            HashMap<String, Integer> num = new HashMap<>();
            
            // 3. 장르별로 각 노래(고유 인덱스 번호)의 재생 횟수를 저장할 HashMap 선언
            HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
            
            // 4. 장르별로 노래의 재생 횟수와 고유 인덱스를 저장
            for (int i = 0; i < genres.length; i++) {
                if (!num.containsKey(genres[i])) {
                    // 장르가 처음 등장하는 경우 초기화
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.put(i, plays[i]); // 노래의 인덱스와 재생 횟수 저장
                    music.put(genres[i], map); // 장르별 노래 정보 저장
                    num.put(genres[i], plays[i]); // 장르별 총 재생 횟수 저장
                } else {
                    // 기존에 존재하는 장르일 경우 데이터 추가
                    music.get(genres[i]).put(i, plays[i]); // 노래 인덱스와 재생 횟수 추가
                    num.put(genres[i], num.get(genres[i]) + plays[i]); // 총 재생 횟수 누적
                }
            }
            
            // 5. 장르별 총 재생 횟수를 기준으로 내림차순 정렬
            List<String> keySet = new ArrayList<>(num.keySet());
            Collections.sort(keySet, (s1, s2) -> num.get(s2) - num.get(s1));
            
            // 6. 각 장르별 상위 2곡 선택
            for (String key : keySet) {
                HashMap<Integer, Integer> map = music.get(key);
                List<Integer> genreKey = new ArrayList<>(map.keySet());
                
                // 재생 횟수를 기준으로 노래 인덱스를 내림차순 정렬
                Collections.sort(genreKey, (s1, s2) -> map.get(s2) - map.get(s1));
                
                // 첫 번째 곡 추가
                album.add(genreKey.get(0));
                // 두 번째 곡이 존재하면 추가
                if (genreKey.size() > 1) {
                    album.add(genreKey.get(1));
                }
            }
            
            // 7. ArrayList를 int 배열로 변환하여 반환
            return album.stream().mapToInt(i -> i).toArray();
        }
    }
}

