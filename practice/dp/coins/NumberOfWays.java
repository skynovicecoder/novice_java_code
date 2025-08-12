package practice.dp.coins;

public class NumberOfWays {

    public static int totalWays(int[] coins, int totalSum) {
        int[] dp = new int[totalSum + 1];
        dp[0] = 1;

        //combinations
       /* for (int coin : coins) {
            for (int i = coin; i <= totalSum; i++) {
                practice.dp[i] += practice.dp[i - coin];
            }
        }*/

        //permutations
        for (int i = 1; i <= totalSum; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[totalSum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int amount = 5;
        System.out.println("Number of combinations to form " + amount + ": " + totalWays(coins, amount));
    }
}
