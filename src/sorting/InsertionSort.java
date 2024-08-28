package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {52,65,2,25,36,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * todo: partial sorting/sort in parts
     *  at each step; the left hand side part is being sorted
     *   worst time complexity = O(n^2)
     *   best time complexity = O(n)
     * */

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }
}
