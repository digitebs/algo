package sort;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPointToOrigin {
    static int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        int[][] res = new int[K][];
        System.arraycopy(points,0, res,0,K);
        return res;
    }

    public static void main(String[] args) {
        int[][] res = kClosest(new int[][]{
                {1,3},{-2,2}
        },1);

        for(int[] r: res){
            System.out.println(Arrays.toString(r));
        }
    }
}
