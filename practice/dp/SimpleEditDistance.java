package practice.dp;

// Levenshtein distance - Min Edit
public class SimpleEditDistance {
    public static int minEditDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: converting empty string to another
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // need i deletions
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // need j insertions
        }

        // Fill the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // substitution
                            Math.min(
                                    dp[i - 1][j],   // deletion
                                    dp[i][j - 1]    // insertion
                            )
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minEditDistance("bcde", "abcdf")); // prints 2

        System.out.println(minEditDistance("cdef", "abcdg")); // prints 4

        System.out.println(minEditDistance("kitten", "sitting")); // prints 3

        System.out.println(minEditDistance("sitting", "kitten")); // prints 3

        System.out.println(minEditDistance("Rocky", "Rocky")); // prints 0
    }
}
