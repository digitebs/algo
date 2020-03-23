package string;

import java.util.ArrayList;
import java.util.List;

/*

Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words,
  the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

 */
public class TextJustification {
  public List<String> fullJustify(String[] words, int maxWidth) {
    int start = 0, len = 0, i = 0; // start is the slow pointer which is the index start of each row
    List<String> ans = new ArrayList<>();
    while (i < words.length) {
      int wc = i - start; // word count
      if (len + words[i].length() + wc
          > maxWidth) { // if current line exceed the max width, justify evenly
        /* Distribute evenly */
        int c = Math.max(1, wc - 1); // the number of words - 1
        int free = maxWidth - len; // free space left
        int avg = free / c; /* distribute the space even amongts the word.
                               notice that if the number of words is 1, avg is simple all free
                             */
        int rem = free % c; // remaining space to distribute
        /* create spaces to append */
        StringBuilder space = new StringBuilder();
        while (avg-- > 0) space.append(" "); // pad space
        /* append all the words from start */
        StringBuilder sb = new StringBuilder();
        while (start < i - 1) {
          sb.append(words[start++]).append(space);
          if (rem-- > 0) sb.append(" ");
        }
        // start will eventually be i
        // if word count is only 1 then append all remaining space
        sb.append(words[start++]).append(wc == 1 ? space : "");
        ans.add(sb.toString());

        len = 0;
      } else {
        len += words[i].length();
        /* last row is left justified */
        if (i == words.length - 1) {
          int c = Math.max(0, wc); // count - (count >= 1 ? 1 : 0);
          int free = maxWidth - len;
          int avg = free - c; // simple get all free no need to distribute evenly

          StringBuilder space = new StringBuilder();
          while (avg-- > 0) space.append(" "); // pad space

          StringBuilder sb = new StringBuilder();
          /* append only single spaces*/
          while (start < i) sb.append(words[start++]).append(" ");
          sb.append(words[i]).append(space); // append the remaing spaces
          ans.add(sb.toString());

          len = 0;
        }
        i++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    new TextJustification()
        .fullJustify(
            new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16)
        .forEach(System.out::println);
  }
}
