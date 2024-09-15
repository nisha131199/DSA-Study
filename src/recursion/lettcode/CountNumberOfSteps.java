package recursion.lettcode;

public class CountNumberOfSteps {
    public static void main(String[] args) {
        System.out.println("Steps: " + countSteps(8, 0));
    }

    /**
     * todo: 1. if the number is even then divide by 2 else subtract by 1
     * */
    static int countSteps(int number, int steps) {
        if (number == 0) return steps;

        if (number%2 == 0) {
            System.out.println(number);
            return countSteps(number/2, ++steps);
        }
        System.out.println(number);
        return countSteps(number-1, ++steps);
    }
}
