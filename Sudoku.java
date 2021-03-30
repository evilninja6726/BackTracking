package backtracking;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        System.out.println(sudoku(board));
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static boolean sudoku(int[][] board) {
        int r = -1, c = -1;
        //int[][] solution=new int[board.length][board.length];
        boolean isEmpty = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    r = i;
                    c = j;
                    isEmpty = true;
                    break;
                }
            }
        }
        if (!isEmpty)
            return true;

        for (int i = 1; i <= board.length; i++) {
            if (isSafe(board, r, c, i)) {
                board[r][c] = i;
                if (sudoku(board)) {
                    return true;
                } else {
                    board[r][c] = 0;
                }
            }
        }

//        for (int i=0;i<board.length;i++){
//            System.out.println(Arrays.toString(board[i]));
//        }
        return false;
    }

    public static boolean isSafe(int[][] sudoku, int r, int c, int n) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][c] == n || sudoku[r][i] == n)
                return false;
        }
        int x = (int) Math.sqrt(sudoku.length);
        int rS = r - r % x;
        int cS = c - c % x;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (sudoku[i + rS][j + cS] == n)
                    return false;
            }
        }
        return true;
    }
}

