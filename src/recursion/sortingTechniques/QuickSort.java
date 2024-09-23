package recursion.sortingTechniques;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,2,5,6,4,9,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * todo: Quick sort
     *  1. select random pivot (from start, end, middle)
     *  2. keep the smaller than pivot in right side & larger on left side
     *  3. do recursion
     * */
    static void quickSort(int[] arr, int lower, int high) {
        if (high <= lower) return;

        // todo: Step 1
        int s = lower,
                e = high,
                mid = s + (e - s)/2,
                pivot = arr[mid];

        // todo: Step 2
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                if (s < e) {
                    int temp = arr[s];
                    arr[s] = arr[e];
                    arr[e] = temp;
                }

                s++; e--;
            }
        }

        /* *
         * todo: Step 3
         *  'e' will reach to the left side of pivot
         *  's' will reach to the right side of pivot
         *  now do recursion from 'lower' till 'e'
         *  and 'high' till 's'
         * */
        quickSort(arr, lower, e);
        quickSort(arr, s, high);
    }
}