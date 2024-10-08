package binarySearch;

import static binarySearch.BinarySearch.doBinarySearching;

public class RotationalListAndPivot {

    public static void main(String[] args) {

        int[] arr = {7,8,9,10,15,1,2,3};
        int targetElement = 4;
        int index;

        index = doSearchingInRotateList(arr, targetElement);
        System.out.println(index);

        index = doPivotSearching(arr);
        System.out.println(index);

    }

    //todo: FINDING PIVOT ==> rotated array i.e., { 8,9,10,2,4,5,6,7,8 }  pivot = 10
    // for more duplicate values this technique fails
    public static int doPivotSearching(int[] arr) {
        if (arr.length == 0) return -1;

        int startIndex = 0;
        int lastIndex = arr.length - 1;

        while (startIndex <= lastIndex) {
            int midIndex = startIndex + ((lastIndex - startIndex)/2);

            //todo: CASE 1
            if (midIndex > startIndex && arr[midIndex] < arr[midIndex - 1]) {
                //todo: mid index start to vada he hove, te check mid element < mid - 1
                return midIndex - 1;
            }
            //todo: CASE 2
            else if (midIndex < lastIndex && arr[midIndex] > arr[midIndex + 1]) {
                //todo: mid index last to chota he hove, te check mid element > mid + 1
                return midIndex;
            }
            //todo: CASE 3
            if (arr[startIndex] == arr[midIndex] && arr[midIndex] == arr[lastIndex]) {
                //todo: mid, start te last elements equal aa; duplicate values
                if (arr[startIndex] > arr[startIndex + 1]) {
                    //todo: follow CASE 1
                    return startIndex;
                }
                startIndex ++;
                if (arr[lastIndex] < arr[lastIndex - 1]) {
                    //todo: follow CASE 1
                    return lastIndex - 1;
                }
                lastIndex --;
            }
            else if (arr[startIndex] < arr[midIndex] || arr[startIndex] == arr[midIndex] && arr[midIndex] > arr[lastIndex]) {
                startIndex = midIndex + 1;
            }
            else {
                lastIndex = midIndex - 1;
            }
        }

        return -1;
    }

    //todo: FINd target in rotated array for non-duplicate values
    public static int doSearchingInRotateList(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int startIndex = 0;
        int lastIndex = arr.length - 1;

        int pivotIndex = doPivotSearching(arr);
        if (pivotIndex != -1) {
            if (arr[pivotIndex] == target) {
                return pivotIndex;
            } else if (arr[startIndex] <= target) {
                lastIndex = pivotIndex - 1;
            } else if (arr[lastIndex] >= target) {
                startIndex = pivotIndex + 1;
            } else {
                //todo: isda matlab target exist he ni karda list te
                return -1;
            }
        }

        return doBinarySearching(arr, target, startIndex, lastIndex);
    }

    /**
     * handled all the duplicates
     * */
    public static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start+(end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]) {
                return mid - 1;
            }

//check for duplicate elements;
            if(arr[mid] == arr[start] && arr[end] == arr[mid]){
                if (start < arr.length-1 && arr[start] > arr[start+1]) {
                    return start;
                }
                start ++;
                if(end > 0 && arr[end] < arr[end-1]) {
                    return end - 1;
                }
                end --;
            }
            if (end < 0) {
                return -1;
            }
            if (start >= arr.length - 1) {
                return -1;
            }
            if(arr[start] < arr[mid] ||
                    arr[start] == arr[mid] && arr[mid] > arr[end]
            ) {
                start = mid +1;
            }  else if(arr[mid] != arr[end]) {
                end = mid - 1;
            } if(arr[end] < arr[mid] ||
                    arr[end] == arr[mid] && arr[mid] < arr[start]
            ) {
                end = mid -1;
            }
        }

        return -1;
    }
}
