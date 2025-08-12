package practice.sudoku;

public class SudokuSolver {

    public boolean solve(SudokuBoard sudoku) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudoku.isEmpty(row, col)) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(sudoku, row, col, num)) {
                            sudoku.setValue(row, col, num);
                            if (solve(sudoku))
                                return true;
                            sudoku.setValue(row, col, 0); // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(SudokuBoard sudoku, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku.getValue(row, i) == num || sudoku.getValue(i, col) == num)
                return false;
        }

        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku.getValue(i, j) == num)
                    return false;
            }
        }
        return true;
    }
}
