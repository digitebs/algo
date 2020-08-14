package array;


/*
Given a string s consisting of small English letters,
 find and return the first instance of a non-repeating character in it.
  If there is no such character, return '_'.

  Input
  abacabad

  Output
  c

 */
public class FirstNotRepeatingCharacter {
  char firstNotRepeatingCharacter(String s) {
    int[] count = new int[26];
    for(int i = 0; i < s.length(); i++){
      count[s.charAt(i) - 'a']++;
    }
    for(int i = 0; i < s.length(); i++){
      if(count[s.charAt(i) - 'a'] == 1)
        return s.charAt(i);
    }
    return '_';
  }

  public static void main(String[] args) {
    //
    FirstNotRepeatingCharacter fd = new FirstNotRepeatingCharacter();
    System.out.print(fd.firstNotRepeatingCharacter("abacabad"));
  }
}
