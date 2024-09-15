package recursion;

public class ArithmeticOperationOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(12345));
        System.out.println(multiplyOfDigits(12345));
        System.out.println(subtractOfDigits(12345));
    }

    static int sumOfDigits(int num) {
        if (num%10 == num) return num;
        return num%10 + sumOfDigits(num/10);
    }

    static int multiplyOfDigits(int num) {
        if (num%10 == num) return num;
        return num%10 * multiplyOfDigits(num/10);
    }

    static int subtractOfDigits(int num) {
        if (num%10 == num) return num;
        return num%10 - subtractOfDigits(num/10);
    }
}
