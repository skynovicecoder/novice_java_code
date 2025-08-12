package practice.dp;

public class MaxRockDP {

    public static int optimalPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        // Traverse bottom to top, and left to right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int fromBelow = (i < rows - 1) ? dp[i + 1][j] : 0;
                int fromLeft = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = grid[i][j] + Math.max(fromBelow, fromLeft);
            }
        }

        // End at top-right
        return dp[0][cols - 1];
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        };
        System.out.println(optimalPath(test1)); // Output: 10

        /*int[][] test2 = {
                {1, 2, 3},
                {0, 0, 4},
                {7, 6, 5}
        };
        System.out.println(optimalPath(test2)); // Output: 25*/
    }
}
