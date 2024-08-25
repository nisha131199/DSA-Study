package string;

public class ScoreOfString {
    public static void main(String[] args) {
        System.out.println(scoreOfString("zaz"));
    }

    public static int scoreOfString(String s) {
        int sum = 0;
        for (int x = 0; x < s.length() - 1; x++) {
            sum += Math.abs(s.charAt(x) - s.charAt(x+1));
        }
        return sum;
    }
}
