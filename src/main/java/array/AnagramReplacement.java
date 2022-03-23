package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

class AnagramReplacement {

  /*
   * Complete the 'countSentences' function below.
   *
   * The function is expected to return a LONG_INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY wordSet
   *  2. STRING_ARRAY sentences
   */

  static HashSet<String> result = new HashSet<>();

  // static long resultCount = int;
  /* print actual combination */
  public static void perm(HashMap<String,String> sortm,HashMap<String,List<String>> hm, List<String> s, int i, String str) {
    if(i== s.size()){
      //System.out.println("split"+ str+" "+str.split(" ").length);
      if(str.split(" ").length >=i)
        result.add(str);
      return;
    }
    // System.out.println("shit"+i+" "+str);
    for(int j =i; j < s.size(); j++){
      //char[] charArray = s.get(j).toCharArray();
      //Arrays.sort(charArray);
      //String sortedString = new String(charArray);
      for(String w : hm.get(sortm.get(s.get(j)))){
        //str+=;
        // System.out.println("welcome"+ str+w+" ");
        perm(sortm,hm,s,j+1,str+w+" ");
      }
      // i++;
    }
  }


  // abc, bac, cba, abc
  // doc dco, doc

  // abc -> abs, bac, cba // 3
  // cdo -> dco, doc

  // list workd
  // sentence list
  // app is doc
  // bac is
  // cba is
  // 3*2 == 6

  /**
   *
   * @param wordSet
   * @param sentences
   * @return
   */
  public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
    HashMap<String,List<String>> hm = new HashMap<>(); //
    HashMap<String,String> sortm = new HashMap<>(); // optimizer
    for(String s: wordSet){ // n
      char[] charArray = s.toCharArray();
      Arrays.sort(charArray); // sort c*logc
      String sortedString = new String(charArray);
      hm.putIfAbsent(sortedString, new ArrayList<String>());
      hm.get(sortedString).add(s); // count
      sortm.put(s, sortedString); // optimizer
    }

    List<Long> count = new ArrayList<>();
    for(String s: sentences){
      long permution = 1;
      result = new HashSet<>();
      List<String> list = Stream.of(s.split(" ")).toList(); // java8

      // compute the permution in this loop
      for(String l: list){
        permution*=hm.get(sortm.get(l)).size();
      }
      count.add(permution);
    }

    return count;
  }

}