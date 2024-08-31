package patterns;

public class Patterns {
    public static void main(String[] args) {
//        patternIncToDec(3);
//        patternDecToInc(3);
//        patternPrism(4);
        patternSquareNumber(4);
    }

    public static void patternSquareNumber(int n) {
        for (int i = 1; i < 2*n; i++) {
            for (int j = 1; j < 2*n; j++) {
                int minDistOfLeftAndRight = Math.min(
                        Math.abs(j), Math.abs(2*n-j)
                );
                int minDistOfUpAndBottom = Math.min(
                        Math.abs(i), Math.abs(2*n-i)
                );
                int num = Math.min(minDistOfLeftAndRight, minDistOfUpAndBottom);
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static void patternPrism(int n) {
        for (int i = 1; i <= 2*n-1; i++) {
            int col = i <= n ? i : 2*n-i;
            int space = i <= n ? n-i : i-n;
            for (int k = 0; k <= space; k++) {
                System.out.print("  ");
            }
            for (int j = col; j >= 1; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <= col; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void patternIncToDec(int n) {
        for (int i = 1; i <= 2*n-1; i++) {
            int col = i <= n ? i : 2*n-i;
            for (int j = 1; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patternDecToInc(int n) {
        for (int i = 1 ; i <= 2*n - 1 ; i++) {
            int col = i <= n ? n-i+1 : i-n+1;
            for (int j = col; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patternNumber(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
