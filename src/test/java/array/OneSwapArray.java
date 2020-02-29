package array;

/*
Two arrays are called similar if one can be obtained from another by swapping at
 most one pair of elements in one of the arrays.

Given two arrays a and b, check whether they are similar.
 */
public class OneSwapArray {
    boolean areSimilar(int[] a, int[] b) {
        int swap = 0;
        int a1=0, a2=0, b1=0,b2=0; // using 4 vars trick
        for(int i = 0; i < a.length; i++){
            if(b[i] != a[i]){
                if(swap == 1) {
                    a2 = a[i];
                    b2 = b[i];
                }else{
                    a1 = a[i];
                    b1 = b[i];
                }
                if(2 <++swap) return false;
            }
        }
        return (a1 == b2 && b1 == a2);
    }

  public static void main(String[] args) {
    //
      OneSwapArray osa = new OneSwapArray();
      System.out.println(osa.areSimilar(new int[]{1,2,3}, new int[]{1,2,3}));
      System.out.println(osa.areSimilar(new int[]{1,2,3}, new int[]{1,3,2   }));
      System.out.println(osa.areSimilar(new int[]{1,2,3}, new int[]{3,2,1}));
      System.out.println(osa.areSimilar(new int[]{2,3,1}, new int[]{1,1,2}));
      System.out.println(osa.areSimilar(new int[]{1,2,3}, new int[]{5,2,1}));
      System.out.println(osa.areSimilar(new int[]{1,2,2}, new int[]{2,1,1}));
      System.out.println(osa.areSimilar(new int[]{1,2,3}, new int[]{2,1,6}));

  }
}
