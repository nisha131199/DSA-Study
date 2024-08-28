package binarySearch.leetcodePractice;

public class RotationArraySolution {
    public static void main(String[] args) {
        int[] arr = {3,1,1,1,1};
        int target = 3;
        System.out.println(search(arr, target));
    }

    public static boolean search(int[] nums, int target) {
        if(nums.length == 0) {
            return false;
        }
        if(nums.length == 1) {
            return nums[0] == target;
        }
        int start = 0, end = nums.length - 1;

        int pivot = findPivot(nums);
        if (pivot != -1) {
            if(nums[pivot] == target) {
                return true;
            }
            if (nums[start] <= target) {
                end = pivot - 1;
            } else if (nums[end] >= target) {
                start = pivot + 1;
            } else {
                return false;
            }
        }

        return doSearching(nums, target, start, end);
    }

    public static boolean doSearching(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start+(end-start)/2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    /**
     * handled all the duplicates
     * */
    public static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start+(end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]) {
                return mid - 1;
            }

//check for duplicate elements;
            if(arr[mid] == arr[start] && arr[end] == arr[mid]){
                if (start < arr.length-1 && arr[start] > arr[start+1]) {
                    return start;
                }
                start ++;
                if(end > 0 && arr[end] < arr[end-1]) {
                    return end - 1;
                }
                end --;
            }
            if (end < 0 || start >= arr.length - 1) {
                return -1;
            }
            if(arr[start] < arr[mid] ||
                    arr[start] == arr[mid] && arr[mid] > arr[end]
            ) {
                start = mid +1;
            }  else if(arr[mid] != arr[end]) {
                end = mid - 1;
            } else if(arr[end] < arr[mid] ||
                    arr[end] == arr[mid] && arr[mid] < arr[start]
            ) {
                end = mid -1;
            }
        }

        return -1;
    }

}