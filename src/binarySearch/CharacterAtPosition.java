package binarySearch;

public class CharacterAtPosition {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String arr = "123456789101112131415161718192021222324252627282930";

        System.out.println(find(arr, 16));

    }

    private static char find(String arr, int target) {
        //char[] characters = arr.toCharArray();
        int start = 0;
        int end = start + 1;
        while ((end + 1) < target) {
            int newStart = end + 1;
            end = end + (end - start + 1)*2;
            start = newStart;
        }

        return doSearching(arr, target, start, end);
    }

    private static char doSearching(String arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if ((mid + 1) == target) {
                return arr.charAt(mid);
            }
            if (mid + 1 > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 'e';
    }
}
