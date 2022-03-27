package search;

import java.util.Arrays;


/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 *
 *
 *
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 */
public class KWeakestRowMatrix {
  public int search(int[] arr){
    int n = arr.length;
    int hi =n-1;
    int lo = 0;

    while(lo <= hi){
      int mid = lo +(hi-lo)/2;
      if(arr[mid] ==1){
        lo = mid+1;
      }else{
        hi =mid-1;
      }
    }

    return lo;
  }
  public int[] kWeakestRows(int[][] mat, int k) {
    int n =mat.length;
    for(int i =0; i < n;i++){
      mat[i][0] = search(mat[i]);
      mat[i][1] = i;
    }

    Arrays.sort(mat,(a,b)->{
      int c= a[0]-b[0];
      return c == 0?  a[1]-b[1]:c;
    });

    int[] res = new int[k];
    while(k-->0){
      res[k] = mat[k][1];
    }

    return res;
  }

  public static void main(String[] args) {
    var kwrm = new KWeakestRowMatrix();
    System.out.println(Arrays.toString(kwrm.kWeakestRows(new int[][]{
        {1, 1, 0, 0, 0},
        {1, 1, 1, 1, 0},
        {1, 0, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 1, 1, 1},
    }, 3)));
  }
}
