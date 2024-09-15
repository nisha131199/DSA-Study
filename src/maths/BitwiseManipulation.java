package maths;

public class BitwiseManipulation {
    public static void main(String[] args) {
        xor(new int[] {1,2,3,5,2,1,5});
        findIthBit(53, 3);
        resetIthBit(53, 5);
        findOddEven(594654761);
        decimalToBinary(1754774750);
        decimalToOctal(8);
        octalToDecimal("10");
        binaryToDecimal("1101");
        System.out.println(findThePowerOfNumber(3,5));
    }

    /* *
     * todo:
     *  1. decimal ==> 0 - 9
     *  2. octal ==> 0 - 7
     *  3. binary ==> 0 & 1
     *  4. hexadecimal ==> 0 - 9 & a - f
     * */

    /**
     * todo: Octal to Decimal conversion
     *  multiply the base 8 with 0-n * num in number from last to start
     * */

    static void octalToDecimal(String num) {
        int decimalValue = 0, j = 0;
        for (int i = num.length()-1; i >= 0 ; i--) {
            System.out.println(Math.pow(8, j));
            decimalValue += (int) Math.pow(8, j) * Integer.parseInt(String.valueOf(num.charAt(i)));
            j++;
        }
        System.out.println(decimalValue);
    }

    /**
     * todo: Binary to Decimal conversion
     *  multiply the base 2 with 0-n * num in number from last to start
     * */
    static void binaryToDecimal(String num) {
        int decimalValue = 0, j = 0;
        for (int i = num.length()-1; i >= 0 ; i--) {
            System.out.println(Math.pow(2, j));
            decimalValue += (int) Math.pow(2, j) * Integer.parseInt(String.valueOf(num.charAt(i)));
            j++;
        }
        System.out.println(decimalValue);
    }

    /**
     * todo: Decimal to Octal conversion
     *  divide the number with base 8
     * */
    static void decimalToOctal(int num) {
        /* *
         * todo: in-built func to verify with my function
         * */
        System.out.println(Integer.toOctalString(num));

        StringBuilder binaryNumber = new StringBuilder();
        while(num > 0) {
            binaryNumber.append(num%8);
            num = num/8;
        }
        System.out.println(
                binaryNumber.reverse()
        );
    }

    /**
     * todo: Decimal to Binary conversion
     *  divide the number with base 2
     * */
    static void decimalToBinary(int num) {
        /* *
         * todo: in-built func to verify with my function
         * */
        System.out.println(Integer.toBinaryString(num));

        StringBuilder binaryNumber = new StringBuilder();
        while(num > 0) {
            binaryNumber.append(num%2);
            num = num/2;
        }
        System.out.println(
                binaryNumber.reverse()
        );
    }

    /**
     * todo: find the number is even or odd
     *  2 pow n ..., 2 pow 2, 2 pow 1, 2 pow 0 ==> 2^n,...,2^2, 2^1, 2^0 ==> 2^n, 1
     *  (2^0) always return 1; which is the reason for number to be odd
     *  we have to find that bit only
     *  perform & operation 1 with number to get the result in even as 0 & 1 as odd
     * */
    static void findOddEven(int n) {
        // n & 1 = n
        // 1 = odd; 0 = even
        System.out.println(
                n & 1
        );
    }

    /**
     * todo: find the ith bit in a value
     *  First Way ==>
     *      1. do the left shift
     *      2. then perform the AND operation
     *      3. lastly do right shift to get the answer
     *  Second Way ==>
     *      1. directly perform the right shift operation on value
     *      2. then do perform AND operation with 1 to get the result
     * */
    static void findIthBit(int n, int i) {
        System.out.println(
                (n & (1L << i - 1)) >> (i - 1)
        );

        // OR

        System.out.println(
                (n >> i - 1) & 1
        );
    }

    /**
     * todo: reset or clear the ith bit to '0'
     *  do the left shift
     *  then compliment it
     *  then just do perform AND operation
     * */
    static void resetIthBit(int n, int i) {
        System.out.println(
                n & ~(1L << i - 1)
        );
    }

    /**
     * todo: find the non-duplicate number among 2 duplicates numbers in an array
     * todo: exclusive or means = if & only if there is only '1' in among two bits & other should be '0'
     *  a ^ 1 = !a = compliment of a
     *  a ^ 0 = a
     *  a ^ a = 0
     * */
    static void xor(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        System.out.println(
                result
        );
    }

    /**
     * todo: find multiple of power 'n'
     * */
    static int findThePowerOfNumber(int num, int pow) {
        int ans = 1, base = num;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans *= base;
            }
            base *= base;
            pow >>= 1;
        }
        return ans;
    }

    /**
     * todo: find the digits in number
     * */
    static int findTheNumOfDigitsOfPower(int pow, int base) {
        return (int) (Math.log(pow) / Math.log(base)) + 1;
    }
}
