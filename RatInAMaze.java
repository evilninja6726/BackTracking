package backtracking;

import java.util.Arrays;

public class RatInAMaze {
    public static void main(String[] args) {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        System.out.println(ratInAMaze(maze));
    }

    public static boolean ratInAMaze(int[][] maze) {
        int[][] solution = new int[maze.length][maze.length];
        if (!ratInAMazeRec(maze, 0, 0, solution)) {
            System.out.println("Solution Doesn't Exists");
            return false;
        } else {
            for (int i = 0; i < maze.length; i++) {
                System.out.println(Arrays.toString(solution[i]));
            }
            return true;
        }
    }

    public static boolean isSafe(int[][] maze, int i, int j) {
        if (i < maze.length && j < maze[i].length && maze[i][j] == 1)
            return true;
        return false;
    }

    public static boolean ratInAMazeRec(int[][] maze, int i, int j, int[][] solution) {
        if (i == maze.length - 1 && j == maze[i].length - 1) {
            solution[i][j] = 1;
            return true;
        }
        if (isSafe(maze, i, j)) {
            solution[i][j] = 1;
            if (ratInAMazeRec(maze, i + 1, j, solution))
                return true;
            else if (ratInAMazeRec(maze, i, j + 1, solution))
                return true;
            solution[i][j] = 0;
        }
        return false;
    }
}
