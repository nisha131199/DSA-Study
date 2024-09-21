package recursion.sortingTechniques;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,1,63,2,7,8,5};

        int[] answer = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(answer));
    }

    /**
     * todo: Merge sort
     *  1. divide the array into two parts
     *  2. sort them via recursion
     *  3. merge them via merge sort two pointers
     *  eg:=         [1,4,63,2,7,8,5]
     *             [1,4,63]   [2,7,8,5]
     *           [1]  [4,63]   [2,7,8,5]
     *          [1]  [4] [63]   [2,7,8,5]
     *         [1]  [4,63]-merger happen     [2,7,8,5]
     *        [1,4,63]-merger happen        [2,7,8,5]
     *        [1,4,63]-sorted ist half    [2,7]  [8,5]
     *        [1,4,63]                  [2] [7]  [8,5]
     *        [1,4,63]              [2] [7]-merger happen  [8,5]
     *        [1,4,63]              [2,7]-sorted  [8] [5]
     *        [1,4,63]               [2,7]   [8] [5]-merger happen
     *        [1,4,63]               [2,7]   [5,8]-sorted
     *        [1,4,63]               [2,7] [5,8]-merger happen
     *        [1,4,63]               [2,5,7,8]-sorted second half
     *        [1,4,63] [2,5,7,8] - merger happen
     *        [1,2,4,5,7,8,63] - sorted
     * */
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length/2;
        int[] first = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merger(first, second);
    }

    static int[] merger(int[] first, int[] second) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[first.length + second.length];

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[k] = first[i];
                i++;
            } else {
                result[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            result[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            result[k] = second[j];
            j++;
            k++;
        }

        return result;
    }
}