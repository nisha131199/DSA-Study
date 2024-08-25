package binarySearch.leetcodePractice;

public class MaxCountOfPosOrNegIntegers {

    public static void main(String[] args) {
        int[] num = {-3,-2,-1,0,0,1,2,3};

        if (num[0] > 0 || num[num.length - 1] < 0) {
            System.out.println(num.length);
        } else {
            int firstIndex = doFloorSearching(num, 0);
            int neg = firstIndex+1;
            int lastIndex = doCeilingSearching(num, 0);
            int pos = num.length - lastIndex;
            if(pos > neg) System.out.println(pos);
            else System.out.println(neg);
        }
    }

    //todo: SMALLEST NO. IN ARRAY WHICH IS >= TARGET NUMBER
    public static int doCeilingSearching(int[] array, int targetElement) {
        if (array.length == 0) {
            return -1;
        }

        int startIndex = 0;
        int lastIndex = array.length - 1;

        if (array[array.length-1] < targetElement) {
            return -1;
        }

        while (startIndex <= lastIndex) {
            int middleIndex = startIndex + ((lastIndex - startIndex)/2);

            if (array[middleIndex] > targetElement)
                lastIndex = middleIndex - 1;
            else
                startIndex = middleIndex + 1;
        }

        return startIndex;
    }

    //todo: SMALLEST NO. IN ARRAY WHICH IS <= TARGET NUMBER
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

            if (array[middleIndex] >= targetElement)
                lastIndex = middleIndex - 1;
            else
                startIndex = middleIndex + 1;
        }

        return lastIndex;
    }
}
