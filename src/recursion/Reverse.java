package recursion;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverseDigits3(15324, 5));
        System.out.println(checkPalindrome(123421));
    }

    static boolean checkPalindrome(int number) {
        int pow = (int) Math.log10(number) + 1;
        return number == reverseDigits3(number, pow);
    }

    static int reverseDigits3(int num, int pow) {
        if (num%10 == num) return num;
        return num%10 * (int) Math.pow(10, pow-1) + reverseDigits3(num/10, pow-1);
    }

    static int sum = 0;

    static void reverseDigits2(int num) {
        if (num == 0) return;
        sum = sum*10 + num%10;
        reverseDigits2(num/10);
    }

    static void reverseDigits(int num) {
        if (num == 0) return;

        System.out.print(num%10 + ", ");
        reverseDigits(num/10);
        System.out.print(num%10 + ", ");
    }
}
