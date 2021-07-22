package tree;

import model.TrieNode;

class Trie {

  TrieNode root = new TrieNode();

  /** Initialize your data structure here. */
  public Trie() {}

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      curr = curr.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
    }
    curr.isEndOfWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode n = curr.children.get(word.charAt(i));
      if (n == null) return false;
      curr = n; // else move forward
    }

    return curr.isEndOfWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      TrieNode n = curr.children.get(prefix.charAt(i));
      if (n == null) return false;
      curr = n; // else move forward
    }
    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
  }
}
