package map;

import java.util.*;

/*
   given a sentence.
    return the list of <word, count> sorted by count, if the words are the same use order in the sentence

   exclude punctuation

    this is linear time where count is use as the key with list of same count
*/
public class WordCountEngine {
  static String[][] wordCountEngine(String document) {
    // your code goes here
    document = document.replaceAll("[^a-zA-Z ]", "");
    String[] tokens = document.toLowerCase().split(" ");

    LinkedHashMap<String, Integer> count = new LinkedHashMap<>();
    for (String t : tokens) {
      if (!t.isEmpty()) count.put(t, count.getOrDefault(t, 0) + 1);
    }

    HashMap<Integer, List<String>> sorted = new HashMap<>();
    for (Map.Entry<String, Integer> e : count.entrySet()) {
      sorted.putIfAbsent(e.getValue(), new ArrayList<>());
      List<String> list = sorted.get(e.getValue());
      list.add(e.getKey());
      sorted.put(e.getValue(), list);
    }

    List<String[]> res = new ArrayList<>();
    for (int i = tokens.length; i >= 1; i--) {
      if (sorted.get(i) == null) continue;
      for (String s : sorted.get(i)) {
        String[] tmp = new String[2];
        tmp[0] = s;
        tmp[1] = String.valueOf(i);
        res.add(tmp);
      }
    }
    return res.toArray(new String[0][]);
  }

  public static void main(String[] args) {
    String[][] res = wordCountEngine("hello, hello, barcelona barcelona! ");

    for (String[] s : res) {
      System.out.println(Arrays.toString(s));
    }
  }
}
