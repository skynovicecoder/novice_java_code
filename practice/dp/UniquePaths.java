package practice.dp;

public class UniquePaths {
    public static int findUniquePaths(int row, int col){
        int[][] dp = new int[row+1][col+1];
        dp[row-1][col-1]=1; //Initial case

        for(int i = row-1; i>=0; i--){
            for(int j = col-1; j>=0;j--){
                dp[i][j] += dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        int m=3,n=6;
        System.out.println(findUniquePaths(m,n)); //21

        int m1=3,n1=3;
        System.out.println(findUniquePaths(m1,n1)); //6

        int m2=3,n2=7;
        System.out.println(findUniquePaths(m2,n2)); //28
    }
}
