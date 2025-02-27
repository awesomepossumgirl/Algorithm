package algo05.Hash;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class Phonekemon {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스 실행
        System.out.println("결과 1: " + (solution.solution(new int[]{3, 1, 2, 3}) == 2));
        System.out.println("결과 2: " + (solution.solution(new int[]{3, 3, 3, 2, 2, 4}) == 3));
        System.out.println("결과 3: " + (solution.solution(new int[]{3, 3, 3, 2, 2, 2}) == 2));
    }

    @Test
    public void 정답() {
        Assert.assertEquals(2, new Solution().solution(new int[]{3, 1, 2, 3}));
        Assert.assertEquals(3, new Solution().solution(new int[]{3, 3, 3, 2, 2, 4}));
        Assert.assertEquals(2, new Solution().solution(new int[]{3, 3, 3, 2, 2, 2}));
    }

    static class Solution {
    	// 프로그래머스 폰켓몬 문제
    	
        public int solution(int[] nums) {
            int max = nums.length / 2;
            HashSet<Integer> nSet = new HashSet<>();

            for (int num : nums) {
                nSet.add(num);
            }

            return Math.min(nSet.size(), max);
        }
    }
}
