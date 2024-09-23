package recursion.subsets;

import java.util.HashSet;

public class StringSubsets {
    public static void main(String[] args) {
        System.out.println(subset("", "ab"));
    }

    static HashSet<String> subset(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            HashSet<String> list = new HashSet<>();
            list.add(processed);
            return list;
        }

        //take it
        HashSet<String> list1 = subset(processed + unprocessed.charAt(0), unprocessed.substring(1));
        //ignore
        HashSet<String> list2 = subset(processed, unprocessed.substring(1));
        //add ascii value
        HashSet<String> list3 = subset(processed + ((int) unprocessed.charAt(0)), unprocessed.substring(1));

        list1.addAll(list2);
        list1.addAll(list3);

        return list1;
    }
}