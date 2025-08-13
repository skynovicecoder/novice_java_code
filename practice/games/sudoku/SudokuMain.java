package practice.games.sudoku;

public class SudokuMain {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuBoard sudokuBoard = new SudokuBoard(board);
        SudokuSolver solver = new SudokuSolver();

        System.out.println("Initial Sudoku:");
        sudokuBoard.display();

        if (solver.solve(sudokuBoard)) {
            System.out.println("\nSolved Sudoku:");
            sudokuBoard.display();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
