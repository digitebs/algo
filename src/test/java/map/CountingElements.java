package map;


/*
  Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.

Input: arr = [1,2,3]
Output: 2
 */
public class CountingElements {
  public int countElements(int[] arr) {
    int res=0;
    int[] map= new int[1001];
    for(int a : arr){
      map[a]++;//
    }
    for(int i = 1;i < 1001; i++){
      if(map[i]!=0)
        res += map[i-1];
    }
    return res;
  }

  public static void main(String[] args) {
    CountingElements ce = new CountingElements();
    System.out.println(ce.countElements(new int[]{1,2,3}));
  }
}
