package binarySearch.leetcodePractice;

public class SearchInRotatedList {
    public static void main(String[] args) {
//        int[] num = num{3,5,1};
        int[] num = {4,5,6,7,0,1,2};
        System.out.println(search(num, 0));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int pivotIndex = findPivot(nums);
        if (pivotIndex != -1) {
            if (nums[pivotIndex] == target) {
                return pivotIndex;
            } else if (nums[0] > target) {
                return doSearch(nums, pivotIndex+1, nums.length-1, target);
            } else {
                return doSearch(nums, 0, pivotIndex-1, target);
            }
        }

        return doSearch(nums, 0, nums.length-1, target);
    }

    public static int doSearch(int[] arr, int startIndex, int lastIndex, int target) {
        while (startIndex <= lastIndex) {
            int mid = startIndex + ((lastIndex - startIndex)/2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                lastIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return -1;
    }

    public static int findPivot(int[] arr) {
        int startIndex = 0, lastIndex = arr.length-1;

        while (startIndex < lastIndex) {
            int midIndex = startIndex + ((lastIndex - startIndex)/2);
            if (midIndex > startIndex && arr[midIndex] < arr[midIndex - 1]) {
                return midIndex - 1;
            }
            if (midIndex < lastIndex && arr[midIndex] > arr[midIndex + 1]) {
                return midIndex;
            }
            if (arr[startIndex] < arr[midIndex]) {
                startIndex = midIndex + 1;
            } else {
                lastIndex = midIndex - 1;
            }
        }

        return -1;
    }
}
