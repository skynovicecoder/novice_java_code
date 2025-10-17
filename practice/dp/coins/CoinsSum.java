package practice.dp.coins;

import java.util.Arrays;

public class CoinsSum {

    public static int minCoins(int[] coins, int totalSum) {
        int[] dp = new int[totalSum + 1];
        Arrays.fill(dp, totalSum + 1);
        dp[0] = 0;

        /*for(int i =1; i<=totalSum; i++){
            for(int coin: coins){
                if(i-coin>=0){
                    dp[i]=Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }*/

        for (int coin : coins) {
            for (int i = coin; i <= totalSum; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[totalSum] > totalSum ? -1 : dp[totalSum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int amount = 13;
        System.out.println("Minimum coins needed: " + minCoins(coins, amount)); // Output: 3

        int[] coinsArray1 = {1, 3, 4, 5};
        int amountReq1 = 7;
        System.out.println("Minimum coins needed: " + minCoins(coinsArray1, amountReq1)); // Output: 2
    }
}
