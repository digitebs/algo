package regex;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext

We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32

 */
public class LengthLongestPath {

  public int lengthLongestPath(String input) {
    final String pattern = "(\\t*?)([\\w ]+(\\.*\\w{1,4})*)";
    Pattern r = Pattern.compile(pattern);

    int max = 0;

    HashMap<Integer, String> hm = new HashMap<>();
    for (String line : input.split("\n")) {
      Matcher m = r.matcher(line);
      // System.out.print(lines[i]+" "+m.find());
      if (m.find()) {
        int tabCount = m.group(1).length();
        String filename = m.group(2);
        String path = (tabCount > 0 ? hm.get(tabCount - 1) + "/" : "") + filename;
        // System.out.println(tabs.length()+" "+path);
        if (filename.contains(".")) max = Math.max(path.length(), max);
        hm.put(tabCount, path); // overrides
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(
        new LengthLongestPath()
            .lengthLongestPath(
                "dir\n"
                    + "\tsubdir1\n"
                    + "\t\tfile1.ext\n"
                    + "\t\tsubsubdir1\n"
                    + "\tsubdir2\n"
                    + "\t\tsubsubdir2\n"
                    + "\t\t\tfile2.ext"));
  }
}
