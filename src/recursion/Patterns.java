package recursion;

public class Patterns {
    public static void main(String[] args) {
        printNumbers(5, 0, 5);
        System.out.println("\n* * * * * *");
        printNumbers2(5, 0, 5);
    }

    /**
     * todo:
     *  1
     *  2 2
     *  3 3 3
     *  4 4 4 4
     *  5 5 5 5 5
     * */
    static void printNumbers(int r, int c, int num) {
        if (r == 0) return;

        if (c < r) {
            printNumbers(r, ++c, num);
            System.out.print(num+" ");
        } else {
            printNumbers(--r, 0, --num);
            System.out.println();
        }
    }

    /**
     * todo:
     *  5 5 5 5 5
     *  4 4 4 4
     *  3 3 3
     *  2 2
     *  1
     * */
    static void printNumbers2(int r, int c, int num) {
        if (r == 0) return;

        if (c < r) {
            System.out.print(num+" ");
            printNumbers2(r, ++c, num);
        } else {
            System.out.println();
            printNumbers2(--r, 0, --num);
        }
    }
}