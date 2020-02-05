package model;

import java.util.HashMap;

public class TrieNode {
  public String content; // dictionaries
  public HashMap<Character, TrieNode> children = new HashMap<>();
  public boolean isEndOfWord;
}
