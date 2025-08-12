package practice.dp.climbStairs;

public class ClimbStairsRecursion2DPBottomUp {

    public static int climbStairs(int n){
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    /*public static BigInteger climbStairs(int n){
        if(n<=2){
            return BigInteger.valueOf(n);
        }
        BigInteger[] practice.dp = new BigInteger[n+1];
        practice.dp[1] = BigInteger.ONE;
        practice.dp[2] = BigInteger.TWO;
        for(int i=3; i<=n; i++){
            practice.dp[i] = practice.dp[i-1].add(practice.dp[i-2]);
        }

        return practice.dp[n];
    }*/

    public static void main(String[] args){
        int stairsCount=10;
        System.out.println("For "+stairsCount+" Stairs, it has possible ways: "+climbStairs(stairsCount));
    }
}
