package practice.dp.coins;

import java.util.Arrays;

public class CoinChange {
    public static int findMinCoinsReq(int[] coinsArray, int amount) {

        //Greedy approach, but it won't work in many case one example {1,3,4,5} with 7 as amount
        /*Arrays.sort(coinsArray);
        int sum = amount;
        int count = 0;
        for (int i = coinsArray.length - 1; i >= 0; i--) {
            while (coinsArray[i] <= sum) {
                sum = sum - coinsArray[i];
                count++;
            }
            if (sum == 0) {
                return count;
            }
        }*/

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;

        for(int i=1;i<=amount; i++){
            for(int j=0; j<coinsArray.length; j++){
                if(coinsArray[j]<=i) {
                    dp[i] = Math.min(dp[i], dp[i - coinsArray[j]] + 1);
                }
            }
        }

        return dp[amount] > amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coinsArray = {1, 5, 10};
        int amount = 12;
        //System.out.println(findMinCoinsReq(coinsArray, amount));

        int[] coinsArray2 = {2};
        int amount1 = 3;
        //System.out.println(findMinCoinsReq(coinsArray2, amount1));

        int[] coinsArray3 = {1,3,4,5};
        int amount3 = 7;
        System.out.println(findMinCoinsReq(coinsArray3, amount3));

    }
}
