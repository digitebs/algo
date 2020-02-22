package recursion;

import java.util.HashSet;

/*
A message is a string of uppercase letters, and it is encoded first using this scheme.
 For example, 'AZB' -> '1262'

Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.
 */
public class DecodeVariation {
  static void decodeVariations(HashSet<String> hs, String res, String s) {

    if (s.length() == 0) hs.add(res);

    if (s.length() >= 1) {
      int val = Integer.parseInt(s.substring(0, 1));
      if (val > 0) {
        String str = res + (char) ('A' + val - 1);
        decodeVariations(hs, str, s.substring(1));
      }
    }
    if (s.length() >= 2) {
      int val = Integer.parseInt(s.substring(0, 2));
      if (val <= 26 && val >= 10) {
        String str = res + (char) ('A' + val - 1);
        decodeVariations(hs, str, s.substring(2));
      }
    }
    // 1 1 1 + 1 1 1

    // 126
    // A,26
    // l, 6
    // l,f <--1 pattern
    // AB,6
    // A 26
    // A z
    // ABE
  }

  static int decodeVariations(String s) {
    HashSet<String> hs = new HashSet<>();
    decodeVariations(hs,"", s);
    System.out.println(hs);
    // your code goes here
    return hs.size();

    /*if (s.length() == 0) return 1;

    int count = 0;
    if (s.length() >= 1) {
      int val = Integer.parseInt(s.substring(0, 1));
      if (val > 0) {
        count += decodeVariations(s.substring(1));
      }
    }
    if (s.length() >= 2) {
      int val = Integer.parseInt(s.substring(0, 2));
      if (val <= 26 && val >= 10) {
        count += decodeVariations(s.substring(2));
      }
    }
    return count;*/
  }

  public static void main(String[] args) {
    System.out.println(decodeVariations("1262"));
  }

  // 1 2 3
  // (1)(23)
  // (12)(3)
  // (1 2 3)
  // 4
  /*
  20,21,22,23,24,25,26
  10,11,12,13,14,15,16,17,18,19,20


  // 12
  //hashset<String> <--
  // (1(2)6)2

  // 1 (262) + (12)(62) <-- i
  //  2
  //  2
  //  1
  */

}
