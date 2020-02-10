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

    HashMap<String, Integer> countMap = new HashMap<>();
    for (String token : tokens)
      if (!token.isEmpty()) countMap.put(token, countMap.getOrDefault(token, 0) + 1);

    // used the tokens as ordering
    HashMap<Integer, List<String>> sortedMap = new HashMap<>();
    for (String token : tokens) {
      if (countMap.containsKey(token)) {
        Integer key = countMap.remove(token);
        sortedMap.putIfAbsent(key, new ArrayList<>());
        sortedMap.get(key).add(token);
      }
    }
    /*
      // if you use linked hashmap for count
      for (Map.Entry<String, Integer> e : count.entrySet()) {
        sorted.putIfAbsent(e.getValue(), new ArrayList<>());
        sorted.get(e.getValue()).add(e.getKey());
      }
    }*/
    List<String[]> res = new ArrayList<>();
    for (int i = tokens.length; i >= 1; i--) { // start counting backward
      if (sortedMap.get(i) == null) continue;
      for (String s : sortedMap.get(i)) {
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
