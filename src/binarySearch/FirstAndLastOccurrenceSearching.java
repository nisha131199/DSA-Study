package binarySearch;

public class FirstAndLastOccurrenceSearching {

    public static void main(String[] args) {

        int[] arr = {-8,0,2,2,2,2,4,5,6,17,17,19,20,21,23,34,45,56,67,89,90,101,102,102,103,105,106,125,129,130};
        int targetElement = 2;
        int index;

        index = doFirstOccurrenceSearching(arr, targetElement, true);
        System.out.println(index);

        index = doFirstOccurrenceSearching(arr, targetElement, false);
        System.out.println(index);

    }

    //todo: FIND THE FIRST OCCURRENCE OF TARGET IN GIVEN ARRAY ORDERED
    //todo: OR
    //todo: FIND THE LAST OCCURRENCE OF TARGET IN GIVEN ARRAY ORDERED
    public static int doFirstOccurrenceSearching(int[] arr, int targetElement, boolean isFirstOcc) {
        if (arr.length == 0) {
            return -1;
        }

        int startIndex = 0;
        int lastIndex = arr.length - 1;
        int findIndex = -1;
        int midIndex;

        while (startIndex <= lastIndex) {
            midIndex = startIndex + ((lastIndex - startIndex)/2);

            if (targetElement > arr[midIndex]) {
                startIndex = midIndex + 1;
            } else if (targetElement < arr[midIndex]) {
                lastIndex = midIndex - 1;
            } else { //todo: je kade isthe ni aya te -1
                findIndex = midIndex;
                if (isFirstOcc) {
                    lastIndex = midIndex - 1;  //todo: pehli occurrence li start val jao
                } else {
                    startIndex = midIndex + 1;  //todo: last occurrence li akhir val nu
                }
            }
        }
        return findIndex;
    }

}
