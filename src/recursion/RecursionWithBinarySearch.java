package recursion;

public class RecursionWithBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,9};
        int target = 3;
        System.out.println(searchTarget(arr, target, 0, arr.length - 1));
    }

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
