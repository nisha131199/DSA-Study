package binarySearch;

import static binarySearch.BinarySearch.doBinarySearching;

public class InfiniteListSearching {

    public static void main(String[] args) {

        int[] arr = {-8,0,2,2,2,2,4,5,6,17,17,19,20,21,23,34,45,56,67,89,90,101,102,102,103,105,106,125,129,130};
        int targetElement = 17;
        int index;

        targetElement = 22;

        index = doSearchingInInfiniteList(arr, targetElement);
        System.out.println(index);

    }

    //todo: SEARCH IN INFINITE LIST ORDERED
    // you can't use list.length() as it is infinite
    public static int doSearchingInInfiniteList(int[] arr, int targetElement) {
        int startIndex = 0;
        int lastIndex = startIndex + 1;

        while (arr[lastIndex] < targetElement) {
            int newStartIndex = lastIndex + 1;
            lastIndex = lastIndex + ((lastIndex - startIndex + 1)*2);
            startIndex = newStartIndex;
        }

        return doBinarySearching(arr, targetElement, startIndex, lastIndex);
    }

}
