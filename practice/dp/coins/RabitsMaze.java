package practice.dp.coins;

public class RabitsMaze {
    public static int numberOfWays(int row, int col){
        int[][] dp = new int[row][col];

        for(int i =0;i<row;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<col;j++){
            dp[0][j]=1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // Current cell = paths from top + paths from left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[row - 1][col - 1];

    }

    public static void main(String[] args){
        int row =18, col=6;
        System.out.println(numberOfWays(row,col));
    }
}
