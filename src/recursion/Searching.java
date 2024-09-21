package recursion;

import java.util.ArrayList;

public class Searching {
    public static void main(String[] args) {
        int[] arr3 = {5,6,7,8,9,1,2,3};
        System.out.println(findTargetInRotatedArray(arr3, 1, 0, arr3.length-1));

        int[] arr = {2,50,36,5,8,23,8,9};
        System.out.println(hasTarget(arr, 2, 0));

        ArrayList<Integer> result = findingTargetIndexes(arr, 8, 0, new ArrayList<>());
        System.out.println(result);

        int[] arr2 = {1,3,5,6,7,9};
        int target = 3;
        System.out.println(searchTarget(arr2, target, 0, arr2.length - 1));
    }

    /**
     * todo: searching in rotated array
     * */
    static int findTargetInRotatedArray(int[] arr, int target, int s, int e) {
        if (e < s) {
            return -1;
        }

        int mid = s + (e - s)/2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[s] <= arr[mid]) {
            if (arr[s] <= target && arr[mid] > target) {
                return findTargetInRotatedArray(arr, target, s, mid - 1);
            } else {
                return findTargetInRotatedArray(arr, target, mid + 1, e);
            }
        }
        if (arr[mid] < target && target <= arr[e]) {
            return findTargetInRotatedArray(arr, target, mid + 1, e);
        } else {
            return findTargetInRotatedArray(arr, target, s, mid - 1);
        }
    }

    /**
     * todo: finding target in linear search
     * */
    static boolean hasTarget(int[] arr, int target, int index) {
        if (index == arr.length) return false;
        if (arr[index] == target) return true;
        return hasTarget(arr, target, ++index);
    }

    /**
     * todo: finding target & returning its position
     *  linear searching for target item index's
     * */
    static ArrayList<Integer> findingTargetIndexes(int[] arr, int target, int index, ArrayList<Integer> nums) {
        if (index == arr.length) return nums;
        if (arr[index] == target) nums.add(index);
        return findingTargetIndexes(arr, target, ++index, nums);
    }

    /**
     * todo: finding target in binary search
     * */
    static int searchTarget(int[] arr, int target, int s, int e) {
        if (e < s) {
            return -1;
        }
        int mid = s + (e-s)/2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return searchTarget(arr, target, s, mid - 1);
        }

        return searchTarget(arr, target, mid + 1, e);
    }
}