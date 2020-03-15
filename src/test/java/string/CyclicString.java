package string;


/*
    medium*

    You're given a substring s of some cyclic string.
    What's the minimum length of string that can be concatenated to itself many times
    to obtain this cyclic string?

    Input: "cabca"
    Output: 3

    "cabca" is a substring of a cycle string "abcabcabcabc..."
     that can be obtained by concatenating "abc" to itself. Thus, the answer is 3

    Input: "aba"
    Output: 2

    "aba" is a substring of a cycle string "ababab..."
    that can be obtained by concatenating "ab" to itself. Thus, the answer is 2
 */
public class CyclicString {
    int cyclicString(String s){
        int min = s.length();
        for(int i =1;i < s.length(); i++){
            String r = s.substring(s.length() -i);
            if(s.replaceAll(r, "").isEmpty()){
                min = Math.min(min,i);
            }else if(s.startsWith(r)){
                min = s.length() -i;
            }
        }

        return min;
    }

  public static void main(String[] args) {
    CyclicString cs = new CyclicString();
    System.out.println(cs.cyclicString("cabca"));
    System.out.println(cs.cyclicString("cabcab"));
    System.out.println(cs.cyclicString("aba"));
    System.out.println(cs.cyclicString("aab"));
    System.out.println(cs.cyclicString("ccccccccccc"));
    System.out.println(cs.cyclicString("abacabaabacab"));
    System.out.println(cs.cyclicString("zazazaza"));
    System.out.println(cs.cyclicString("abbaab"));
  }
}
