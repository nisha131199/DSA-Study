package linkedlist;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println("18 isHappy : "+isHappy(18));
        System.out.println("19 isHappy : "+isHappy(19));
    }

    /**
     * todo: Find if the number isHappy
     *  eg - 19 = 1 + 81 = 82
     *       82 = 64 + 4 = 68
     *       68 = 36 + 64 = 100
     *       100 = 1 + 0 + 0 = 1 (isHappy when at the end you got 1 of square of digits)
     * */
    static boolean isHappy(int num) {
        if (num < 10) {
            return false;
        }

        int slow = num, fast = num;
        do {
            slow = squareOf(slow);
            fast = squareOf(squareOf(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        } else {
             return false;
        }
    }

    private static int squareOf(int num) {
        int sum = 0;
        while (num > 0) {
            int n = num%10;
            sum += n*n;
            num /= 10;
        }
        return sum;
    }
}