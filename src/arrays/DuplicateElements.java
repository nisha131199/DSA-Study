package arrays;

import java.util.HashSet;

public class DuplicateElements {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(removeElement(new int[]{0,1,3,0,4}, 2));
    }

    /**
     * todo: remove the target element & order doesn't matter
     *  use two pointers to swap target element with last element
     * */

    static int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] == val) {
                swap(start, end, nums);
                end --;
            } else {
                start ++;
            }
        }
        if (start == nums.length) return start;
        if (nums[start] == val) return start;
        return start+1;
    }

    /**
     * todo: remove duplicates and maintain the order
     *  use two pointer to swap the duplicate & store it into hashset to get the size
     * */

    static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (set.contains(nums[start])) {
                swap(start, end, nums);
                end --;
            } else {
                set.add(nums[start]);
                start ++;
            }
        }
        sort(nums, set.size());
        return set.size();
    }

    static void sort(int[] nums, int size) {
        for (int i = 0; i < size - 1; i++) {
            int j = i+1;
            while (j > 0) {
                if (nums[j] < nums[j-1]) {
                    swap(j-1, j, nums);
                    j--;
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int start, int end, int[] nums) {
        int t = nums[end];
        nums[end] = nums[start];
        nums[start] = t;
    }
}
