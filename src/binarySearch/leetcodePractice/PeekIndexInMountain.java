package binarySearch.leetcodePractice;

public class PeekIndexInMountain {
    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 0) return -1;
        int s=0,e=arr.length-1;
        while (s<e) {
            int mid = s + ((e-s)/2);
            if (arr[mid] < arr[mid+1]) {
                s = mid+1;
            } else {
                e = mid;
            }
        }
        return -1;
    }
}
