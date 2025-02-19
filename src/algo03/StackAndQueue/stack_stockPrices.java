package algo03.StackAndQueue;

public class stack_stockPrices {

    public static void main(String[] args) {
        // 프로그래머스 주식가격 문제
    	
        int[] prices1 = {1, 2, 3, 2, 3};
        int[] result1 = solution(prices1);
        System.out.print("Test 1: ");
        for (int i : result1) {
            System.out.print(i + " ");
        }
        // 4 3 1 1 0 (각각 가격이 떨어지기까지 걸리는 시간)

        System.out.println();

        int[] prices2 = {5, 3, 6, 7, 4};
        int[] result2 = solution(prices2);
        System.out.print("Test 2: ");
        for (int i : result2) {
            System.out.print(i + " "); // 1 1 2 1 0 (각각 가격이 떨어지기까지 걸리는 시간)
        }
    }

    // prices 배열에 대해, 각 주식 가격이 언제 떨어지는지 구하는 문제
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 결과를 담을 배열

        // 주식 가격 배열을 순회
        for (int i = 0; i < prices.length; i++) {
            // 각 주식 가격에 대해 이후 가격을 순회
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++; // 주식 가격이 떨어질 때까지 시간 증가
                // 만약 현재 가격이 이후 가격보다 크다면, 주식 가격이 떨어진 것이므로 반복 종료
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer; // 결과 배열 반환
    }
}
