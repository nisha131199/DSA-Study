package binarySearch.leetcodePractice;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-2,-3};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            if(nums[0] >= 0) {
                return nums[0];
            } else {
                return -1;
            }
        }

        int s = Integer.MIN_VALUE , e = 0;
        boolean posExists = false;
        for(int num: nums) {
            if (num >= 0) posExists = true;
            s = Math.max(num,s);
            if (num > 0) {
                e += num;
            }
        }

        if (e == 0) {
            if (!posExists) return s;
            else return 0;
        }

        while(s <= e) {
            int m = s + (e - s)/2;
            int sum = 0, maxSum = 0;

            for(int n: nums) {
                maxSum = Math.max(sum, maxSum);
                if (sum+n >= m) {
                    sum += n;
                    s = m+1;
                    break;
                }
                if (sum+n < 0) {
                    sum = 0;
                } else {
                    sum += n;
                }
            }
            maxSum = Math.max(sum, maxSum);
            if(maxSum < m) {
                e = m - 1;
            }
        }

        return e;
    }
}
