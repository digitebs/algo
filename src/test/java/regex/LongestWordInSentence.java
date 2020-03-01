package regex;

/*
    find the longest word n the senetence

    "Ready, steady, go!"

    "steady"
 */
public class LongestWordInSentence {
    String longestWord(String text) {
        String[] texts = text.split("[^a-zA-Z]+");
        int max = 0;
        String res ="";
        for(String t: texts){
            if(t.length() > max){
                max = t.length();
                res = t;
            }
        }

        return res;
    }

  public static void main(String[] args) {
    //
      LongestWordInSentence lws = new LongestWordInSentence();
      System.out.println(lws.longestWord("Ready, steady, go!"));
      System.out.println(lws.longestWord("ABCd"));
      System.out.println(lws.longestWord("You are the best!!!!!!!!!!!! CodeFighter ever!"));

  }
}
