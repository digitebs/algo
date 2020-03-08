package map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Given two strings a and b, both consisting only of lowercase English letters,
 your task is to calculate how many strings equal to a can be constructed using only letters from the string b?
  Each letter can be used only once and in one string only.

  a = "abc" and b = "abccba"
  output = 2
 */
public class StringConstruction {
  int stringsConstruction(String a, String b) {
    int res = 0;
    int[] count = new int[26];
    // Map<Character, Integer> t = new HashMap<>();
    for (char c : b.toCharArray()) {
      count[c - 'a']++;
    }
    while (true) {
      for (char c : a.toCharArray()) {
        if (--count[c - 'a'] < 0) return res;
      }
      res++;
    }

  }

  public static void main(String[] args) {
    StringConstruction sc = new StringConstruction();
    System.out.println(sc.stringsConstruction("abc", "abccba"));
  }
}
