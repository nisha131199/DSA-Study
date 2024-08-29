package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 *  **************************** if range is [0,n] the value will lie at index = value itself *********************************
 *  **************************** if range is [1,n] the value will place at index = value - 1  *********************************
 * */
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {4,0,3,1};
//        cyclicSort(arr);
        int value = findSmallestPositiveMissingNumberFrom0ToN(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(value);

        int[] arr2 = {4,3,2,7,11,3,1,9,15,12,6,5,5};
        List<Integer> value2 = findSmallestPositiveMissingNumbersFromRange1ToN(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(value2);
    }

    /**
     * todo: for range [1,n]
     * */
    private static List<Integer> findSmallestPositiveMissingNumbersFromRange1ToN(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] != i+1) {
                int correctPos = arr[i] - 1;
                if (correctPos < arr.length && arr[i] != arr[correctPos]) {
                    swap(arr, i, correctPos);
                } else {
                    i++;
                    list.add(i);
                }
            } else {
                i++;
            }
        }
        return list;
    }

    /**
     * todo: for range [0,n]
     * */
    private static int findSmallestPositiveMissingNumberFrom0ToN(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] >= arr.length || arr[i] == i) {
                i++;
            } else {
                swap(arr, i, arr[i]);
            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            int correctPos = arr[i] - 1;
            if (arr[i] == arr[correctPos]) {
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
