package recursion;

public class CountNInNumber {
    public static void main(String[] args) {
        System.out.println(countN(123451, 1, 0));
    }

    static int countN(int number, int n, int count) {
        if (number == 0) return count;

        if (number%10 == n) return countN(number/10, n , ++count);
        else return countN(number/10, n, count);
    }
}
