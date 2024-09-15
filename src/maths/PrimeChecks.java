package maths;

public class PrimeChecks {
    public static void main(String[] args) {
//        for (int i = 1; i < 10; i++) {
//            System.out.println(i+"-"+isPrimeOrNot(i));
//        }

        sieve(23, new boolean[24]);
    }

    /**
     * todo: find the numbers which are prime from 1 till the number
     *  1. find the prime number, then eliminates its multiple
     *  2. repeat 1 till the square-root of number
     *  3. remember the default value of boolean is always false
     *  4. so, now suppose the false at index is prime & then put the multiple of it is true
     * */
    static void sieve(int number, boolean[] prime) {
        for (int i = 2; i*i <= number; i++) {
            if (prime[i] == false) {
                for (int j = i*2; j <= number; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 2; i <= number ; i++) {
            if (!prime[i]) {
                System.out.println("prime - "+i);
            }
        }
    }

    /**
     * todo: check whether target is prime or not
     *  1. run the loop till square-root of the target
     *  2. check is the target is divisible by the numbers or not
     * */
    static boolean isPrimeOrNot(int number) {
        if (number == 1) return true;

        int n = 2;

        while (n*n <= number) {
            if (number % n == 0)
                return false;
            n++;
        }

        return true;
    }
}