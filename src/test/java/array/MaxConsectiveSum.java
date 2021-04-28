package array;

/*

    given an array of nearby building in club street. return the maximum total number of people
    that potentially can be affected by COViD-19
    the virus can only be transmitted up to max k buildings nearby from source, the source can start anywhere

    Input:
    arr = 2, 3, 5, 1, 6
    k= 2

    Output: 8

    2 + 3 = 5;
    3 + 5 = 8; // highest
    5 + 1 = 6;
    1 + 6 = 7.
    Thus, the answer is 8.
 */
public class MaxConsectiveSum {
  // sliding window
  int arrayMaxConsecutiveSum(int[] arr, int k) {
    int i = 0;
    int max = 0;

    while(i++<k) max += arr[i];

    int temp = max;
    do max = Math.max(temp += (arr[i] - arr[i - k]), max);
    while (++i < arr.length);
    return max;
  }

  public static void main(String[] args) {
    MaxConsectiveSum cs = new MaxConsectiveSum();
    System.out.println(cs.arrayMaxConsecutiveSum(new int[] {2, 3, 5, 1, 6}, 2));
    System.out.println(cs.arrayMaxConsecutiveSum(new int[] {2, 3, 5, 1, 6}, 3));
    System.out.println(cs.arrayMaxConsecutiveSum(new int[] {1, 3, 4, 2, 4, 2, 4}, 4));
    System.out.println(
        cs.arrayMaxConsecutiveSum(
            new int[] {
              963, 741, 22, 851, 399, 382, 190, 247, 494, 452, 891, 532, 795, 920, 465, 831, 344,
              391, 582, 897, 763, 951, 735, 806, 320, 702, 200, 59, 870, 345, 695, 321, 817, 83,
              416, 36, 914, 335, 117, 985, 690, 303, 875, 556, 292, 309, 496, 791, 509, 360, 235,
              784, 607, 341
            },
            23));
  }
}
