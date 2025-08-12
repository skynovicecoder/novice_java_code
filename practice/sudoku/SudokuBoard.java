package practice.sudoku;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(int[][] board) {
        if (board.length != 9 || board[0].length != 9)
            throw new IllegalArgumentException("Board must be 9x9");
        this.board = board;
    }

    public int getValue(int row, int col) {
        return board[row][col];
    }

    public void setValue(int row, int col, int value) {
        board[row][col] = value;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public void display() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("------+-------+------");

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
