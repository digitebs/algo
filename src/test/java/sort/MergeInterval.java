package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeInterval {

    // merge non overlapping intervals
    static int mergeInterval(int k, List<List<Integer>> list) {
        Collections.sort(list, (o1, o2) -> {
            int diff = o1.get(0) - o2.get(0);
            if (diff == 0)
                return o1.get(1) - o2.get(1);
            return diff;
        });


        for (int i = list.size() - 1; i > 0; i--){
            for (int j = i - 1; j > 0; j--) {
                if (i != j && list.get(i).get(0) > list.get(j).get(1)) {
                    list.get(j).set(1, list.get(i).get(1)); // oway since they dont overlapp merge them
                    list.remove(i); //remove this;
                    break;
                }
            }
        }

        return list.size() - 1;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2));
        list.add(Arrays.asList(1,3));
        list.add(Arrays.asList(1,4));
        list.add(Arrays.asList(4,5));
        list.add(Arrays.asList(6,8));
        System.out.println(mergeInterval(1, list));

    }
}
