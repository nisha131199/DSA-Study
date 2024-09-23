package recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithIteration {
    public static void main(String[] args) {
        System.out.println(subset(new int[]{1,2,2,2}));
    }

    static List<List<Integer>> subset(int[] arr) {
        if (arr.length == 0) return new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int s, e = 0;
        for (int j = 0; j < arr.length; j++) {
            s = 0;
            if (j > 0 && arr[j] == arr[j-1]) {
                s = e + 1;
            }
            e = outer.size() - 1;
            for (int i = s; i <= e; i++) {
                s++;
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[j]);

                outer.add(inner);
            }
        }

        return outer;
    }
}