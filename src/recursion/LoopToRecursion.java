package recursion;

public class LoopToRecursion {
    public static void main(String[] args) {
        print(5);
        System.out.println();
        printInReverse(5);
    }

    /**
     * todo: here it will print & then recall it to print further numbers
     * */
    static void print(int n) {
        if (n == 0) return;

        System.out.print(n + " ");
        print(n-1);
    }

    /**
     * todo: here it will call until it reaches to end then print the values
     * */
    static void printInReverse(int n) {
        if (n == 0) return;

        printInReverse(n-1);
        System.out.print(n + " ");
    }
}
