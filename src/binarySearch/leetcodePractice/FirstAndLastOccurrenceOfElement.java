package binarySearch.leetcodePractice;

public class FirstAndLastOccurrenceOfElement {
    public static void main(String[] args) {
        int[] num = {5,7,7,8,8,10};
        int[] index = searchRange(num, 8);
        System.out.println(index);
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = index(nums, target, true);
        if (start == -1) {
            return new int[] {-1, -1};
        }
        int end = index(nums, target, false);
        return new int[] {start, end};
    }

    public static int index(int[] nums, int target, boolean firstOccurrence) {
        int start = 0, end = nums.length-1;
        int index = -1;
        while (start <= end) {
            int mid = start + ((end-start)/2);
            if (nums[mid] == target) {
                index = mid;
                if (firstOccurrence) {
                    end = mid - 1;
                } else {
                    start = start + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }
}
