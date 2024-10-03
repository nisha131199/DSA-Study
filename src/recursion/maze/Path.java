package recursion.maze;

public class Path {
    public static void main(String[] args) {
        path("", 1,1);
    }

    /**
     * todo: find how many path to reach destination
     *  1. only goes to right & down & diagonally
     *  2. if reaches the last column then go down only
     *  3. if reaches column then go right to target place
     *  1  2  3
     *  4  5  6
     *  7  8  9
     * */
    static void path(String p, int row, int col) {
        if (row == 3 && col == 3) {
            System.out.println(p);
            return;
        }

        if (row < 3) {
            path(p + "D", row+1, col);
        }
        if (col < 3) {
            path(p + "R", row, col+1);
        }
        if (row < 3 && col < 3) {
            path(p + "V", row+1, col+1);
        }
    }
}