package combination;

import java.util.LinkedHashSet;


/*
  given a string input. return all string permutation

  input: abc
  output:
  abc
  acb
  bac
  bca
  cab
  cba


  input: rakuten
 */
public class StringPermutation {

  public void testPermute() throws Exception {
    // permute("", "apple");
   // permute("", "abc");
   // permute("", "eren");
    substr("eren");
    System.out.println(words);
  }

  static LinkedHashSet<String> words = new LinkedHashSet<>();
  public static  void substr(String front){

    for(int i =0;i < front.length(); i++){
      //for(int j = i;  j < front.length() - i; j++){
        for(int k = i+1; k < front.length() +1 ; k++){
          //System.out.println(j+" "+k);
          words.add(front.substring(i,k));
        }
     // }
    }

  }
  public static void permute(String front, String back) {

    if (back.length() == 0) {
      System.out.print(front+",");
    } else {
      for (int i = 0; i < back.length(); i++) {
        permute(
            front + back.charAt(i),
            back.substring(0, i) + back.substring(i + 1, back.length()));
      }
    }
  }

  public void isPermution() {

    isPermution("", "cda", "bc");
  }

  private void isPermution(String prefix, String str, String str2) {

    if (0 == str.length()) {
      System.out.println(prefix);
    } else {

      // abc
      // bac
      // bca
      for (int i = 0; i < str.length(); i++) {
        isPermution(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), str2);
      }
    }
  }
}
