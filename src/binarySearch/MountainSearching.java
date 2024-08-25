package binarySearch;

import static binarySearch.BinarySearch.doBinarySearching;

public class MountainSearching {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10,15,4,2,1};
        int targetElement = 4;
        int index;
        targetElement = 2;

        //todo: Searching To Find The Smallest Index Of the Target
        index = doMountainSearching(arr, targetElement);
        System.out.println(index);

        index = doPeekMountainSearching(arr);
        System.out.println(index);

    }

    //todo: MOUNTAIN LIST ==> first increasing peek then decreasing
    public static int doPeekMountainSearching(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int startIndex = 0, lastIndex = arr.length - 1;

        while(startIndex < lastIndex) {
            //todo: start should be less than end
            // kyunki dovo akhir te peek value kol he pujuge
            int middle = startIndex + ((lastIndex - startIndex)/2);
            if (arr[middle] > arr[middle+1]) {
                lastIndex = middle;
            } else {
                startIndex = middle + 1;
            }
        }

        //todo: hamesha ithe he ana; kyunki ya te max num in between miluga
        // ya te akhir te -> matlab list sorted aa, no peek available. return -1 if required
        return startIndex;
    }

    //todo: MOUNTAIN LIST ==> find the target in first order with peek index ==>0 till peekIndex.
    // if not found then ==> peek+1 till length-1
    public static int doMountainSearching(int[] arr, int targetElement) {
        if (arr.length == 0) {
            return -1;
        }

        int peekIndex = doPeekMountainSearching(arr);
        int firstSearch = doBinarySearching(arr, targetElement, 0, peekIndex);
        if (firstSearch != -1) {
            return firstSearch;
        }
        return doBinarySearching(arr, targetElement, peekIndex + 1, arr.length - 1);
    }
}
