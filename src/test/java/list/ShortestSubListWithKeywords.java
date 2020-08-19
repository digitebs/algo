package list;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

medium

  given a string description and word1 and word2,
   find the the minimum substring containing both words

   Input:
   john likes to play and visit jane but jane doesn't want john to visit her.

   Output:
   jane doesn't want john

 */
public class ShortestSubListWithKeywords {
  public void subList(String desc, String k1, String k2) {
    String[] arr = desc.split(" ");

    String ans="";
    int min = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (i < arr.length && j < arr.length) {
      // System.out.println(i+" "+j);
      if (arr[i].equals(arr[j])) {
          i=j;
       //   j++;
      } else if (arr[i].equals(k1) && !arr[j].equals(k2)
          || arr[i].equals(k2) && !arr[j].equals(k1)) {
      //  j++;
      } else if (arr[i].equals(k1) && arr[j].equals(k2) || arr[i].equals(k2) && arr[j].equals(k1)) {
        if (min > j - i) {
          min = j - i;
          ans =  IntStream.rangeClosed(i,j).mapToObj(k -> arr[k]).collect(Collectors.joining(" "));
        }
        i = j;
        //j++;
      } else {
        i++;
      }
      j++;
    }

    System.out.println(ans);


  }

  public static void main(String[] args) {
    ShortestSubListWithKeywords sswk = new ShortestSubListWithKeywords();
    sswk.subList("a c b c a c b x","a", "b");
    sswk.subList("a a a a a a b","a", "b");
    sswk.subList("c b e f g a b","a", "b");
    sswk.subList(
        "john likes to visit and play with jane  but jane doesn't want john to visit her", "jane", "john");
  }
}
