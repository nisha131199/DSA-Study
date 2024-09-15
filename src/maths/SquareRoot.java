package maths;

public class SquareRoot {
    public static void main(String[] args) {
//        System.out.println(findSquareRoot(40, 3));
        System.out.println(newtonsSquareRoot(40));
    }

    /**
     * todo: newtons formula to find the square root
     *  --> sqrt(root) = (x + root/x)/2
     * */
    static double newtonsSquareRoot(int number) {
        double x = number, result;

        while (true) {
            result = (x + number/x)/2;
            if (Math.abs(result - x) < 0.5) {
                break;
            }
            x = result;
        }
        return result;
    }

    /**
     * todo: Find the square root of number
     *  1. find the mid & take its square, if = to the number then return
     *  2. else if mid * mid > target number; end = mid - 1
     *  3. else  start = mid + 1
     * */
    static double findSquareRoot(int number, int precise) {
        int start = 1, end = number;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid*mid == number) {
                return mid;
            }
            if (mid * mid > number) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        double result;
        if (start * start < number) {
            result = start;
        } else {
            result = end;
        }
        double inc = 0.1;
        for (int i = 0; i < precise; i++) {
            while (result*result <= number) {
                result += inc;
            }
            result -= inc;
            inc /= 10;
        }

        return result;
    }
}