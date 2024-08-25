package binarySearch;

public class SplitIntoMSubList {

    public static void main(String[] args) {

        /*
        * 5,34,2,5,2        Max sum    Answer will be the lowest among the highest sum
        * [5,34,2,5] [2]
        *    46       2   =>  46
        * [5,34,2] [5,2]
        *    41      7    =>  41
        * [5,34] [2,5,2]
        *   39      9     =>  39            ANSWER
        * [5] [34,2,5,2]
        *  5      43      =>  43
        * */
        int[] unsortedArray = {5,34,2,5,2};
        int mPieces = 2;

        System.out.println(doSplitArrayInMPieces(unsortedArray, mPieces));
    }

    //todo: split the array into `m` continuous sub-arrays
    // ******** IMPORTANT **********
    public static int doSplitArrayInMPieces(int[] arr, int m) {
        int start = 0; //todo: min pieces = arr.length i.e., the max value in array is the min
        int end = 0; //todo: max pieces = 1 i.e., the sum of all elements is max
        for (int value: arr) {
            start = Math.max(start, value);
            end += value;
        }

        //todo: the range is [start, end]
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;

            for (int num: arr) {
                if (sum+num > mid) {
                    sum = num;
                    pieces ++;
                } else {
                    sum += num;
                }
            }

            if (pieces <= m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start; //todo: min & max are equal here bcz of above conditions
    }
}
