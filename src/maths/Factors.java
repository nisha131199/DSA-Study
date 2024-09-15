package maths;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        findTheFactor(20);
    }

    /**
     * todo: Find the factors of number
     *  1. loop till sqrt of number
     *  2. if num1 * num2 = num; then num2 * num1 also = num
     * */
    static void findTheFactor(int num) {
        ArrayList<Integer> nums = new ArrayList<>();
        int i = 1;
        while (i*i <= num) {
            if (num % i == 0) {
                nums.add(num/i);
                System.out.print(i+" ");
            }
            i++;
        }
        for (i=nums.size()-1; i >= 0; i--)  {
            System.out.print(nums.get(i)+" ");
        }
    }
}