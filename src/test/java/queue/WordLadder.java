package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
   Input:
   beginWord = "hit",
   endWord = "cog",
   wordList = ["hot","dot","dog","lot","log","cog"]

   must only transform if 1 edit

   Output: 5
*/
public class WordLadder {
  /* bfs */
  static int shortestWordEditPath(String source, String target, String[] words) {
    // your code goes here

    Queue<String> q = new LinkedList<>();
    q.offer(source);

    boolean[] visited = new boolean[words.length];
    int level = 1;
    while (!q.isEmpty()) {

      for (String curr : new ArrayList<>(q)) {
        for (int i = 0; i < words.length; i++) {
          if (visited[i] == false && isOneEdit(words[i], curr)) {
            visited[i] = true;
            if (words[i].equals(target)) return level;
            q.offer(words[i]); // /
          }
        }
        q.poll();
      }
      level++; //
    }

    return -1;
  }

  // a is current // you never touch
  static boolean isOneEdit(String a, String b) {
    boolean editOnce = false;
    // lets assume a is smaller
    if (a.length() != b.length()) return false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) ;
      //  j++;
      else if (editOnce == true) {
        return false;
      } else {
        //  j++; // still allow
        editOnce = true;
      }
    }
    return true;
  }
}
