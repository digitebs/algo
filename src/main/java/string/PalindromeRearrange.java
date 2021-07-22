package string;

/*

Easy* no need to recompute all combination

Given a string, find out if its characters can be rearranged to form a palindrome.

Input: aabb
Output: true

Input:  abba
Output: true

 */
public class PalindromeRearrange {
  boolean palindromeRearranging(String s) {
    // palindorme is character /2
    // agghhh // no padlidrome due to ?? %2 == 1 is 2

    int[] count = new int[26];
    for(int i = 0; i < s.length(); i++){
      count[s.charAt(i)-'a']++;
    }

    int mod = 0;
    for(int i = 0; i < 26; i++){
      if(count[i]%2 == 1) mod++;
    }

    return mod <= 2;

  }

  public static void main(String[] args) {
    PalindromeRearrange pr = new PalindromeRearrange();
    System.out.println(pr.palindromeRearranging("aabb"));
    System.out.println(pr.palindromeRearranging("abba"));
    System.out.println(pr.palindromeRearranging("abdhuierf"));
  }
}
