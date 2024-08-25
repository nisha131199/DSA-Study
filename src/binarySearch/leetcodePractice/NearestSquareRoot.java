package binarySearch.leetcodePractice;

public class NearestSquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrt(1234567893));
    }

    public static int mySqrt(int x) {
        long s=1, l=x/2;
        if (x == 1) return 1;
        while (s<l) {
            long mid = s+((l-s)/2);
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                l = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return (int) s;
    }
}
