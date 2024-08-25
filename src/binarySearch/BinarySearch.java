package binarySearch;

/**
 * todo:
 *  1. Find order
 *  2. loop while start <= end
 *  3. mid = start + (end - start)/2 ==> (start + end)/2
 *  4. if mid == target return mid
 *  5. else if mid < target ==> start = mid + 1
 *  6. else end = mid - 1
 *  7. return -1 when start > end that means we're unable to find the target
 * */
public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {-8,0,2,2,2,2,4,5,6,17,17,19,20,21,23,34,45,56,67,89,90,101,102,102,103,105,106,125,129,130};
        int targetElement = 20;
        int index;

        index = doBinarySearching(arr, targetElement, 0, arr.length-1);
        System.out.println(index);

    }

    public static int doBinarySearching(int[] array, int targetElement, int startIndex, int lastIndex) {
        if (array.length == 0) {
            return -1;
        }

        boolean isASC = array[startIndex] < array[lastIndex];

        while (startIndex <= lastIndex) {
            int middleIndex = startIndex + ((lastIndex - startIndex)/2);

            if (array[middleIndex] == targetElement)
                return middleIndex;
            else {
                if (isASC) {
                    if (array[middleIndex] > targetElement)
                        lastIndex = middleIndex - 1;
                    else
                        startIndex = middleIndex+1;
                } else {
                    if (array[middleIndex] < targetElement)
                        lastIndex = middleIndex-1;
                    else
                        startIndex = middleIndex+1;
                }
            }
        }

        return -1;
    }

}














