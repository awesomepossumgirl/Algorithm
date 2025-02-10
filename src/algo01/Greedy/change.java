package algo01.Greedy;

import java.util.Scanner;

public class change {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int minCoinCnt = 0;
		int coins[] = { 500, 100, 50, 10 };
		for (int coin : coins) {
			minCoinCnt += (total / coin);
			total %= coin;
		}
		System.out.println("result = " + minCoinCnt);
		sc.close();

	}

}