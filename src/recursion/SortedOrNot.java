package recursion;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,8,9};
        System.out.println(isSortedInASC(nums, 0));
        int[] nums2 = {10,6,5,2,1,3};
        System.out.println(isSortedInDSC(nums2, 0));
    }

    /**
     * check the list is sorted in ascending order
     * */
    static boolean isSortedInASC(int[] nums, int index) {
        if (index == nums.length - 1) return true;
        return nums[index] < nums[index+1] && isSortedInASC(nums, index + 1);
    }

    /**
     * check the list is sorted in descending order
     * */
    static boolean isSortedInDSC(int[] nums, int index) {
        if (index == nums.length - 1) return true;
        return nums[index] > nums[index+1] && isSortedInDSC(nums, index + 1);
    }
}