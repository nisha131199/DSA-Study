package recursion.maze;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        findAllPaths(maze, "", 0, 0);
    }

    /**
     * todo: find all the paths to reach point
     *  1. go to right side
     *  2. go diagonally
     *  3. go down
     *  4. go left side
     *  5. to up side
     *  6. don't repeat your path by using backtracking
     * */
    static void findAllPaths(boolean[][] maze, String p, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        if (r < maze.length - 1) {
            //bottom - downside
            findAllPaths(maze, p + "B", r+1, c);
        }
        if (c < maze.length - 1) {
            //right
            findAllPaths(maze, p + "R", r, c+1);
        }
        if (r < maze.length - 1 && c < maze.length - 1) {
            //diagonally
            findAllPaths(maze, p + "D", r+1, c+1);
        }
        if (c > 0) {
            //left
            findAllPaths(maze, p + "L", r, c-1);
        }
        if (r > 0) {
            //top - upside
            findAllPaths(maze, p + "T", r-1, c);
        }

        maze[r][c] = true;
    }
}