package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {52,65,2,25,36,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * todo: Select an element & put it at it's correct position. either by min value or by max value
     *  do the same until the array is sorted.
     *  worst time complexity = O(n^2)
     *  best time complexity = O(n^2)
     * */

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int swapIndex = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[swapIndex] < arr[j]) {
                    swapIndex = j;
                }
            }
            if (swapIndex != arr.length - 1 - i) {
                swap(arr, swapIndex, arr.length - 1 - i);
            }
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }
}
