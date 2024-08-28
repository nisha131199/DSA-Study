package sorting;

import java.util.Arrays;

/**
 * todo: **** given arr of range 1 .. n ****
 *  find a missing positive number
 *  unsorted array to find the smallest missing positive number
 *  find duplicate number
 *  time complexity: n-1
 *  worst: (n-1) + n = 2n - 1 = n
 *  range will always starts with 1 till n.
 *  i.e., num at position num - 1
 *  eg: 4 at 4-1 = 3 position
 * */
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] == i + 1) {
                i++;
            } else {
                swap(arr, i, arr[i] - 1);
            }
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }
}
