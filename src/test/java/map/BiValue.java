package map;

import java.util.HashSet;

public class BiValue {
    HashSet<Integer> hs = new HashSet<>();
    public int solution(int[] A) {
        int max = 1;
        // write your code in Java SE 8
        for (int i = 0; i < A.length; i++) {
            hs.add(A[i]);
            for (int j = i + 1; j < A.length; j++) {
                hs.add(A[j]);
                if (hs.size() > 2) break;
                else max = Math.max(max, j - i + 1); //add 1 inclusive
            }
            hs.remove(A[i]);
        }
        return max;
    }

}
