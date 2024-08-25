package binarySearch.leetcodePractice;

public class CeilingOfTargetCharacter {
    public static void main(String[] args) {
        char[] letters = {'x','x','y','y'};
        char target = 'x';
        char index = nextGreatestLetter(letters, target);
        System.out.println(index);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        if (letters.length == 0) {
            return 0;
        }

        int startIndex = 0;
        int lastIndex = letters.length - 1;

        if (letters[letters.length-1] <= target) {
            return letters[0];
        }

        while (startIndex <= lastIndex) {
            int middleIndex = startIndex + ((lastIndex - startIndex)/2);

            if (letters[middleIndex] > target)
                lastIndex = middleIndex - 1;
            else
                startIndex = middleIndex + 1;
        }

        return letters[startIndex];
    }

}
