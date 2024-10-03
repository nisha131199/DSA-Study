package recursion.subsets;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(permutation("", "abc"));
    }

    /**
     * todo: String.substring(0, i) take from 0 till i, don't include the 'ith'.
     *  ""/abc
     *  a/bc
     *  b+a & a+b /c
     *  c+ba, b+ca, ba+c & c+ab, a+cb, ab+c
     * */
    static ArrayList<String> permutation (String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> str = new ArrayList<>();
            str.add(processed);
            return str;
        }

        char ch = unProcessed.charAt(0);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i <= processed.length(); i++) {
            String ist = processed.substring(0, i);
            String _2nd = processed.substring(i, processed.length());

            list.addAll(permutation(ist + ch + _2nd, unProcessed.substring(1)));
        }

        return list;
    }
}