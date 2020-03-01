package array;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
   medium* intersenting problem due to logic of optimziation

   given a sequence arr
   find if theres at most 1 element  in arr that can be remove to obtain increasing sequence

   O(n)
*/
public class AlmostIncreasingSequence {
  boolean almostIncreasingSequence(int[] a) {
    int edit = 0, n = a.length - 1;
    for (int i = 0; i < n; i++)
      if (a[i] >= a[i + 1]) {
        if (++edit > 1) return false;
        if (i - 1 >= 0)
          if (i + 1 == n || a[i - 1] == a[i + 1]) a[i + 1] = a[i];
          else a[i] = a[--i];
      }
    return true;
  }

  public static void main(String[] args) {
    //
    AlmostIncreasingSequence ais = new AlmostIncreasingSequence();
    System.out.println(ais.almostIncreasingSequence(new int[] {1, 3, 2, 1}));
    System.out.println(ais.almostIncreasingSequence(new int[] {1, 3, 2}));
    System.out.println(ais.almostIncreasingSequence(new int[] {1, 2, 1, 2}));
    System.out.println(ais.almostIncreasingSequence(new int[] {1, 2, 3, 1}));
    System.out.println(ais.almostIncreasingSequence(new int[] {1, 1, 2, 3}));
    System.out.println(ais.almostIncreasingSequence(new int[] {4, 1, 2, 3}));
    System.out.println(ais.almostIncreasingSequence(new int[] {1, 3, 2, 3, 4}));
    System.out.println(ais.almostIncreasingSequence(new int[] {4, 1, 3, 2}));

    // range randomizer
    List<Integer> a = IntStream.range(-50, 50).boxed().collect(Collectors.toList());
    // Collections.shuffle(a);
    System.out.println(a);
    System.out.println(ais.almostIncreasingSequence(new int[] {2, 1, 4, 3}));
    System.out.println(
        ais.almostIncreasingSequence(
            new int[] {
              -50, -49, -48, -47, -46, -45, -44, -43, -42, -41, -40, -39, -38, -37, -36, -35, -34,
              -33, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17,
              -16, -15, -14, -13, 100, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4,
              5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
              28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49
            }));
  }
}
