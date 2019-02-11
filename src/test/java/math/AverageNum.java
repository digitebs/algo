package math;

import java.util.Arrays;
import java.util.List;
import  static java.lang.System.out;

public class AverageNum {
    static double avg(List<Double> arr){
        return arr.stream().mapToDouble( d -> d/arr.size()).sum();
    }

    public static void main(String[] args) {
        out.println(avg(Arrays.asList(2.0,3.0)));
        out.println(avg(Arrays.asList(1.0,2.0,3.0)));
    }
}
