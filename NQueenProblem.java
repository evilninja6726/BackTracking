package backtracking;

import java.util.Arrays;

public class NQueenProblem {
    public static void main(String[] args) {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        nQueen(board);
    }

    public static boolean nQueen(int[][] chess) {
        //int[][] solution=new int[n][n];
        if (!nQueenRec(chess, 0)) {
            System.out.println("Not Possible");
            return false;
        } else {
            for (int i = 0; i < chess.length; i++)
                System.out.println(Arrays.toString(chess[i]));
            return true;
        }
    }

    public static boolean nQueenRec(int[][] chess, int c) {
        if (c == chess.length)
            return true;
        for (int i = 0; i < chess.length; i++) {
            if (isSafe(chess, i, c)) {
                chess[i][c] = 1;
                if (nQueenRec(chess, c + 1))
                    return true;
                chess[i][c] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] chess, int r, int c) {
        for (int i = 0; i < c; i++) {
            if (chess[r][i] == 1)
                return false;
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }

        for (int i = r, j = c; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] == 1)
                return false;
        }
        return true;
    }
}
