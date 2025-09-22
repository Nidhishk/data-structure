public class Sudoku {
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

        sudokuSolver(board, 0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean sudokuSolver(int[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return sudokuSolver(board, row + 1, 0);
        if (board[row][col] != 0) return sudokuSolver(board, row, col + 1);

        for (int num = 1; num <= 9; num++) {
            if (isSafeSudoku(board, row, col, num)) {
                board[row][col] = num;
                if (sudokuSolver(board, row, col + 1)) return true;
                board[row][col] = 0;    // Backtracking
            }
        }
        return false;
    }

    private static boolean isSafeSudoku(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num) return false;
        }

        int gridRow = row / 3;
        int gridCol = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cellRow = gridRow * 3 + i;
                int cellCol = gridCol * 3 + j;
                if (board[cellRow][cellCol] == num) return false;
            }
        }
        return true;
    }
}
