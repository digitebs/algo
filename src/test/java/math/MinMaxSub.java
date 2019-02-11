package math;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.abs;

public class MinMaxSub {
    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                for (int k = 0; k < c.size(); k++) {
                    int max = abs(a.get(i) - b.get(j));
                    max = max(max, abs(b.get(j) - c.get(k)));
                    max = max(max, abs(c.get(k) - a.get(i)));
                    min = min(min, max);
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 4, 10);
        List<Integer> b = Arrays.asList(2, 15, 20);
        List<Integer> c = Arrays.asList(10, 12);
        System.out.println(new MinMaxSub().minimize(a, b, c));

    }

}
