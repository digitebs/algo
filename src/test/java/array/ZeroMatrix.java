package array;

import java.util.Arrays;


/**
 * n^2 where we ini initialize an empty array, point the row reference to same array if there is no 0 found.
 */
public class ZeroMatrix {

    private static int[][] zeroMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            boolean z = false;
            for (int j = 0; j < m && !z; j++)
                if (arr[i][j] == 0) z = true;
            if (!z) res[i] = arr[i]; // put a reference
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 2}, {1, 0, 1}, {1, 2, 0}};
        System.out.println(Arrays.deepToString(zeroMatrix(arr)));
    }
}
