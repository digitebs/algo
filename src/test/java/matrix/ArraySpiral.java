package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySpiral {

    /*
        use border switch approach
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        if(n == 0) return list;
        int m = matrix[0].length;
        int x =0,y =0,d =0,k =  n*m; // position x
        int[] dr = new int[] {0,1,0,-1};
        int[] dc = new int[] {1,0,-1,0};
        do {
            list.add(matrix[x][y]); //okay we got one
            matrix[x][y]=-999; // means visited
            x += dr[d];
            y += dc[d];
            if(x<0 || y < 0 || x >= n || y >= m || matrix[x][y] == -999) {
                x -= dr[d];
                y -= dc[d]; // revert then apply
                d = ++d%4;
                // move to next direction
                x += dr[d];
                y += dc[d];
            }

        } while(0 < --k );
        return list;
    }

    static int[][] spiral(int n){

        int[][] arr = new int[n][n];
        int limit =  n*n;
        int x =0,y =0; // position x
        int val=0; // how many
        int[] dr = new int[] {0,1,0,-1};
        int[] dc = new int[] {1,0,-1,0};
        int d = 0;
        while(val++ < limit){
            arr[x][y] = val; //okay we got one
            x += dr[d];
            y += dc[d];
            if(x<0 || y < 0 || x >= arr.length || y >= arr[x].length || arr[x][y] != 0) { // if its a wall we change direction
                x -= dr[d];
                y -= dc[d]; // revert then apply
                d = ++d%4;
                x += dr[d];
                y += dc[d];
            }
        }
        return arr;
    }

    static int[][] spiral2(int n){

        int[][] arr = new int[n][n];
        int k =  n*n;
        int x =0,y =-1; // position x
        int[] dr = new int[] {0,1,0,-1};
        int[] dc = new int[] {1,0,-1,0};
        int d = 0;
        for(int i = 1; i <= k;i++){
            x += dr[d];
            y += dc[d];
            arr[x][y] = i;

            // look ahead variables
            int x1 = x + dr[d];
            int y1 = y + dc[d];
            if(x1 < 0 || y1 < 0 || x1 >= n || y1 >= n || arr[x1][y1] != 0) { // if its a wall we change direction
                d = ++d%4;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = spiral2(3);
        System.out.print(Arrays.deepToString(arr));
    }
}
