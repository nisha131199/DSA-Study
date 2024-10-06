package recursion.maze;

public class N_Queen {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[4][4];
        System.out.println(nQueen(maze, 0));
    }

    /**
     * todo: Place all queens into the board such that no queen hit one another
     *  1. col start from 0 till end
     *  2. row from top till last row
     *  3. space complexity = n * n
     *  4. recurrence relation = n * T(n-1) + O(n^2)
     *  => time complexity = O(n^3 + n!) ==> O(n!)    === n! = n * n-1 * n-2 * ...
     * */
    static int nQueen(boolean[][] queenMaze, int row) {
        if (row == queenMaze.length) {
            display(queenMaze);
            System.out.println("*******");
            return 1;
        }

        int count = 0;
        for (int col = 0; col < queenMaze[row].length; col++) {
            //place the queen if it is safe
            if (isSafeToPlaceQueen(queenMaze, row, col)) {
                queenMaze[row][col] = true;
                count += nQueen(queenMaze, row + 1);
                queenMaze[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafeToPlaceQueen(boolean[][] queenMaze, int row, int col) {
        // todo: check vertical rows from 0 till row only because the below row don't contain queens yet

        // todo: vertically upward ^|^
        for (int i = 0; i < row; i++) {
            if (queenMaze[i][col]) {
                return false;
            }
        }

        // todo: diagonally left side ^\^
        //  if the row is 4 & col is 3 then we will go 3 times to go diagonally left only
        int maxToGoLeft = Math.min(row, col);
        for (int i = 1; i <= maxToGoLeft; i++) {
            if (queenMaze[row - i][col - i]) {
                return false;
            }
        }

        // todo: diagonally right side ^/^
        //  if the row is 4 & col is 3 then we will go 3 times to go diagonally right only
        int maxToGoRight = Math.min(row, queenMaze.length - col - 1);
        for (int i = 1; i <= maxToGoRight; i++) {
            if (queenMaze[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] queenMaze) {
        for (boolean[] row: queenMaze) {
            for (boolean value: row) {
                if (value) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }
}