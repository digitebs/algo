package array;


/*
    hard intersenting problem due to logic of optimziation

    given a sequence arr
    find if theres at most 1 element  in arr that can be remove to obtain increasing sequence

    O(n)
 */
public class AlmostIncreasingSequence {
    boolean almostIncreasingSequence(int[] a) {
        int d = 0, n = a.length -1;
        for (int i = 0; i < n; i++)
            if (a[i] >= a[i + 1]) {
                if(++d > 1) return false;
                if (i - 1 >= 0)
                    if (i + 1 == n || a[i - 1] == a[i + 1]) a[i + 1] = a[i];
                    else a[i] = a[--i];
            }
        return true;
    }

  public static void main(String[] args) {
    //
      AlmostIncreasingSequence ais = new AlmostIncreasingSequence();
      System.out.println(ais.almostIncreasingSequence(new int[]{1,3,2,1}));
      System.out.println(ais.almostIncreasingSequence(new int[]{1,3,2}));
      System.out.println(ais.almostIncreasingSequence(new int[]{1,2,1,2 }));
      System.out.println(ais.almostIncreasingSequence(new int[]{1,2,3,1 }));
      System.out.println(ais.almostIncreasingSequence(new int[]{1,1,2,3 }));
      System.out.println(ais.almostIncreasingSequence(new int[]{4,1,2,3 }));
      System.out.println(ais.almostIncreasingSequence(new int[]{1,3,2,3,4 }));
      System.out.println(ais.almostIncreasingSequence(new int[]{4,1,3,2}));
  }
}
