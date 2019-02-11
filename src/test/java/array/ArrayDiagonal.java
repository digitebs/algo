package array;

import java.util.Arrays;

public class ArrayDiagonal {
    public int[] findDiagonalOrder(int[][] matrix) {
        int[] dx = {1, -1},dy = {-1, 1}, rx = {0, 1}, ry = {1, 0};
        int n = matrix.length;
        if (n == 0) return new int[0];
        int m = matrix[0].length;
        int[] res = new int[n * m];
        int k = 0, d = 1, r = 0, x, y, posx = 0, posy = 0;
        do {
            res[k++] = matrix[posx][posy];
            x = posx + dx[d % 2];
            y = posy + dy[d % 2];
            if (x < 0 || y < 0 || x >= n || y >= m) {
                x = posx + rx[r % 2];
                y = posy + ry[r % 2];
                r++;
                if (x < 0 || y < 0 || x >= n || y >= m) {
                    x = posx + rx[r % 2];
                    y = posy + ry[r % 2];
                }
                d++;
            }
            posx = x;
            posy = y;
        } while (k < res.length);
        return res;
    }
}
