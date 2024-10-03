package recursion.maze;

public class PathRestrictions {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {
                {true, true, true},
                {true, false, true},
                {false, true, true}
        };
        pathRestriction(maze, "", 0, 0);
    }

    static void pathRestriction(boolean[][] maze, String p, int row, int col) {
        if (row == maze.length - 1 && col == maze.length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        if (row < maze.length - 1) {
            pathRestriction(maze, p + "D", row+1, col);
        }
        if (col < maze.length - 1) {
            pathRestriction(maze, p + "R", row, col+1);
        }
    }
}