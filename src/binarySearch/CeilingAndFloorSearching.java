package binarySearch;

public class CeilingAndFloorSearching {

    public static void main(String[] args) {

        int[] arr = {-8,0,2,2,2,2,4,5,6,17,17,19,20,21,23,34,45,56,67,89,90,101,102,102,103,105,106,125,129,130};
        int targetElement;
        int index;

//        targetElement = 18;
        targetElement = 75;

        index = doCeilingSearching(arr, targetElement);
        System.out.println(index);

//        targetElement = -9;
        targetElement = -3;

        index = doFloorSearching(arr, targetElement);
        System.out.println(index);

    }

    //todo: SMALLEST NO. IN ARRAY WHICH IS >= TARGET NUMBER ORDERED
    public static int doCeilingSearching(int[] array, int targetElement) {
        if (array.length == 0) {
            return -1;
        }

        int startIndex = 0;
        int lastIndex = array.length - 1;

        if (array[array.length-1] < targetElement) {
            //todo: jado akhiri vala he target to nikka aa, ceiling swah milni
            // te start index kade vi akhir toh bahr ni jauga
            return -1;
        }

        while (startIndex <= lastIndex) {
            int middleIndex = startIndex + ((lastIndex - startIndex)/2);
            //todo: je sirf greater value he chahidi not equal
//            if (array[middleIndex] == targetElement)
//                return array[middleIndex];
            if (array[middleIndex] > targetElement)
                lastIndex = middleIndex - 1;
            else
                startIndex = middleIndex + 1;
        }

        //todo: hamesha start index he ceiling te jauga
        return array[startIndex];
    }

    //todo: SMALLEST NO. IN ARRAY WHICH IS <= TARGET NUMBER ORDERED
    public static int doFloorSearching(int[] array, int targetElement) {
        if (array.length == 0) {
            return -1;
        }

        int startIndex = 0;
        int lastIndex = array.length - 1;

        if (array[0] > targetElement) {
            return -1;
        }

        while (startIndex <= lastIndex) {
            int middleIndex = startIndex + ((lastIndex - startIndex)/2);

            if (array[middleIndex] > targetElement)
                lastIndex = middleIndex - 1;
            else
                startIndex = middleIndex + 1;
        }

        return array[lastIndex];
    }
}
