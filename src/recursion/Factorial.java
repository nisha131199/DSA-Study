package recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(5));
    }

    static int findFactorial(int n) {
        if (n <= 1) return 1;
        return findFactorial(n - 1) * n;
    }
}
