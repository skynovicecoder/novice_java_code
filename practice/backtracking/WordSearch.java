package practice.backtracking;

import java.util.Arrays;

public class WordSearch {
    static int rows;
    static int cols;
    static boolean[][] visited;

    public static boolean isWordExist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= rows || c >= cols
                || board[r][c] != word.charAt(i)
                || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r, c + 1, i + 1) ||
                dfs(board, word, r, c - 1, i + 1);
        visited[r][c] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'A', 'B', 'C', 'D'},
                {'S', 'A', 'A', 'T'},
                {'A', 'C', 'A', 'E'}
        };

        String word = "CAT";

        System.out.println("Given array : " + Arrays.deepToString(input) + " : word : " + word + " :is present: " + isWordExist(input, word));

        char[][] input2 = new char[][]{
                {'A', 'M', 'C', 'D'},
                {'E', 'A', 'N', 'G'}
        };

        String word2 = "MANGO";

        System.out.println("Given array : " + Arrays.deepToString(input2) + " : word : " + word2 + " :is present: " + isWordExist(input2, word2));

        char[][] input1 = new char[][]{
                {'A', 'B', 'C', 'D'},
                {'P', 'P', 'L', 'E'}
        };

        String word1 = "APPLE";

        System.out.println("Given array : " + Arrays.deepToString(input1) + " : word : " + word1 + " :is present: " + isWordExist(input1, word1));
    }
}
