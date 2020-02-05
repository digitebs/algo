package matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDiagonal {
    static int[] findDiagonalOrder(int[][] matrix) {
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

    static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(a.get(j).get(i-j));
                // System.out.println(a.get(j).get(i-j));

            }

            res.add(row);
        }


        for (int i = 1; i < a.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = a.size()-1; j >=i; j--) {
                //System.out.println(i+" "+j);

                row.add(0,a.get(j).get((a.size()-1)-j +i));
                //System.out.println(a.get(j).get((a.size()-1)-j +i));

            }

            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
         System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));

        ArrayList<ArrayList<Integer>> p = new ArrayList<>();
        p.add(new ArrayList<>(Arrays.asList(1,2,3)));
        p.add(new ArrayList<>(Arrays.asList(4,5,6)));
        p.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(diagonal(p));
    }

}
