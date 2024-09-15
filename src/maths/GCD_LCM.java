package maths;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println(lcm(11, 3));
    }

    /**
     * Find the greatest common in divisor
     * GDC = HCF
     * */
    static int gcd (int a, int b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }

    /**
     * Least common multiple
     * --> LCM (a,b) = (a*b)/HCF(a,b)
     * */
    static int lcm(int a, int b) {
        return (a * b)/gcd(a, b);
    }
}