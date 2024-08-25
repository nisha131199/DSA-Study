package binarySearch.leetcodePractice;

public class PerfectSquare {
    public static void main(String[] args) {
        boolean value = isPerfectSquare(808201);
        System.out.println(value);
    }

    public static boolean isPerfectSquare(int num) {
        long s=1, l=num/2;
        if (num == 1) return true;
        while (s<=l) {
            long mid = s+((l-s)/2);
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                l = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }
}
