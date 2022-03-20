package math;


/**
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
 *
 * If it cannot be done, return -1.
 *
 * Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 *
 * Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 *
 */
public class MinimumDominoRotations {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int val =0;
    int[] hm = new int[8];
    for(int i=0; i < tops.length;i++){
      int a = tops[i];
      int b = bottoms[i];
      hm[a]++;
      hm[b]++;

      if(hm[a] >= hm[b]){
        val = a;
      }
    }


    // System.out.println(val);
    int a =0, b=0;
    for(int i=0; i < tops.length;i++){
      if(bottoms[i] != val && tops[i] != val)
        return -1;

      if(bottoms[i] == val && tops[i] != val)
        a++;

      if(bottoms[i] != val && tops[i] == val)
        b++;
    }

    return Math.min(a,b);
  }
}
