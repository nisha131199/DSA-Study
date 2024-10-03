package recursion.subsets;

public class Dice {
    public static void main(String[] args) {
        dice("", 3);
    }

    /**
     * todo: 1,2,3,4,5,6
     *  target 3
     *  ""/3
     *  i=1             i=2     i=3
     *  ----------------------------
     *  1/2             2/1     3/0
     *  i=1     i=2     i=1
     *  -----------------------
     *  11/1    12/0    21/0
     *  i=1
     *  ----
     *  111/0
     * */
    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target ; i++) {
            dice(p + i, target - i);
        }
    }
}