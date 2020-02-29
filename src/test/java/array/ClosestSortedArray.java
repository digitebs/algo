package array;

/*

Easy* tricky to optimized

Given a sorted array of integers a, your task is to determine which element of a is closest to all other values of a.

a =[2,4,7]

x=2: abs(2-2) + abs(4-2) + abs(7-2) = 7
x=4: abs(2-4) + abs(4-4) + abs(7-4) = 5.. x = 4 answer is 4
x=7: abs(2-7) + abs(4-7) + abs(7-7) = 8

if there is tie return smaller x;

 */
public class ClosestSortedArray {
  int absoluteValuesSumMinimization(int[] a) {

    return a[a.length / 2 - (a.length % 2 == 0 ? 1 : 0)];
    /*int min = (int)1e9+7, x = 0;
    for (int i = 0; i < a.length; i++) {
      int temp=0;
      for (int j = 0; j < a.length; j++) {
        temp += Math.abs(a[i] - a[j]);
      }
      if (temp < min) {
        x = a[i];
        min = temp;
      }
    }
    return x;*/

  }

  public static void main(String[] args) {
    //
    ClosestSortedArray csa = new ClosestSortedArray();
    System.out.println(csa.absoluteValuesSumMinimization(new int[] {2, 4, 7}));
  }
}
