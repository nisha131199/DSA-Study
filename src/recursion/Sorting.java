package recursion;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {1,4,63,2,7,8,5};
        insertionSort(arr, 0, 1);
//        bubbleSort(arr, 0, arr.length-1);
//        selectionSort(arr, 0, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * todo: do insertion sorting in recursion
     * */
    static int[] insertionSort(int[] arr, int s, int e) {
        if (e == arr.length) return arr;

        if (e > 0) {
            if (arr[e] < arr[e - 1]) {
                swap(arr, e, e-1);
                return insertionSort(arr, s, --e);
            } else {
                return insertionSort(arr, ++s, s+1);
            }
        } else {
            return insertionSort(arr, ++s, s+1);
        }
    }

    /**
     * todo: do selection sorting in recursion
     * */
    static int[] selectionSort(int[] arr, int s, int e, int temp) {
        if (e == 0) return arr;

        if (s < e) {
            if (arr[temp] < arr[s+1]) {
                temp = s+1;
            }
            return selectionSort(arr, ++s, e, temp);
        } else {
            swap(arr, temp, e);
            return selectionSort(arr, 0, --e, 0);
        }
    }

    /**
     * todo: do bubble sorting in recursion
     * */
    static int[] bubbleSort(int[] arr, int s, int e) {
        if (e == 0) return arr;

        if (s < e) {
            if (arr[s] > arr[s+1]) {
                swap(arr, s, s+1);
            }
            return bubbleSort(arr, ++s, e);
        } else {
            return bubbleSort(arr, 0, --e);
        }
    }

    static void swap(int[] arr, int s, int e) {
        int temp = arr[e];
        arr[e] = arr[s];
        arr[s] = temp;
    }
}