package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountTriplets {

    // interesting problem to study using {{HashMap}} progression using 2 maps. assigning the next value to the next, adding increment
    // of previous one
    private static long countTriplets(List<Long> arr, long r) {
        HashMap<Long,Long> h = new HashMap<>();
        HashMap<Long,Long> m = new HashMap<>();
        // map
        long res = 0;
        for(Long a : arr){
            res += h.getOrDefault(a,0L);
            h.put(a * r, h.getOrDefault(a * r,0L) + m.getOrDefault(a,0L));
            m.put(a * r, m.getOrDefault(a * r,0L) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList(5L,10L,20L),2));
    }
}
