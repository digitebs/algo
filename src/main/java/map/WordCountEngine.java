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

    Map<String, Integer> countMap = new HashMap<>();
    for (String token : tokens)
      if (!token.isEmpty()) countMap.put(token, countMap.getOrDefault(token, 0) + 1);

    // used the tokens as ordering
    Map<Integer, List<String>> sortedMap = new HashMap<>();
    for (String token : tokens) {
      if (countMap.containsKey(token)) {
        int freq = countMap.remove(token);
        sortedMap.putIfAbsent(freq, new ArrayList<>());
        sortedMap.get(freq).add(token);
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
    for (int freq = tokens.length; freq >= 1; freq--) { // start counting backward
      if (sortedMap.get(freq) == null) continue;
      for (String word : sortedMap.get(freq)) {
        res.add(new String[]{word, Integer.toString(freq)});
      }
    }
    return res.toArray(new String[0][]);
  }

  // O(n) engine 2
  Map<String, Integer> populateWordsToCounts(String str) {

    final String ESC = "\'-";
    Map<String, Integer> hm = new HashMap<>();
    int s = 0;
    str = str + " "; //hack add space
    for(int i = 0; i < str.length(); i++){
      char c= str.charAt(i);
      if(!Character.isLetter(c) && !ESC.contains(c+"")){
        String key =str.substring(s,i);
        if(!key.isEmpty() && !ESC.contains(key)){
          String cap = Character.toUpperCase(str.charAt(s))
                  + str.substring(s+1,i);
          if(hm.containsKey(cap)){
            hm.put(key,hm.getOrDefault(cap,0)+1);
            hm.remove(cap);
          }else
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        s = i+1;// exclude sapce
      }
    }
    return hm;
  }

  public static void main(String[] args) {
    WordCountEngine wce = new WordCountEngine();
    String[][] res = wce.wordCountEngine("hello, hello, barcelona barcelona! ");

    for (String[] s : res) {
      System.out.println(Arrays.toString(s));
    }

    System.out.println(wce.populateWordsToCounts("Dessert - mille-feuille cake"));
    System.out.println(wce.populateWordsToCounts("Mmm...mmm...decisions...decisions"));
    System.out.println(wce.populateWordsToCounts("Allie's Bakery: Sasha's Cakes"));
  }
}
