package stack_queue;

import java.util.Arrays;

public class StackPractice {
    public static void main(String[] args) {
        int[] arr1 = {4,2,4,6,1};
        int[] arr2 = {2,1,0,5};

        System.out.println(maxLengthForSteps(10,arr1,arr2,0,0));
    }

    static int maxLengthForSteps(int total, int[] arr1, int[] arr2, int count, int sum) {
        if (sum >= total || arr1.length == 0 || arr2.length == 0) {
            if (sum > 10)
                return count-1;
            return count;
        }

        int count1 = maxLengthForSteps(total, Arrays.copyOfRange(arr1, 1, arr1.length), arr2, count+1, sum + arr1[0]);
        int count2 = maxLengthForSteps(total, arr1, Arrays.copyOfRange(arr2, 1, arr2.length), count+1, sum + arr2[0]);

        return Math.max(count1, count2);
    }
}