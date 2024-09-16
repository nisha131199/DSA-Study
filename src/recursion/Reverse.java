package recursion;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverseDigits(15324, 5));
        System.out.println(checkPalindrome(123421));
    }

    static boolean checkPalindrome(int number) {
        int pow = (int) Math.log10(number) + 1;
        return number == reverseDigits(number, pow);
    }

    static int reverseDigits(int num, int pow) {
        if (num%10 == num) return num;
        return num%10 * (int) Math.pow(10, pow-1) + reverseDigits(num/10, pow-1);
    }

    static void reverseDigits(int num) {
        if (num == 0) return;

        System.out.print(num%10 + ", ");
        reverseDigits(num/10);
        System.out.print(num%10 + ", ");
    }
}
