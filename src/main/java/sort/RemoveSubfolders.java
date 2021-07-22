package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of folders, remove all sub-folders in those folders and return in any order the
 * folders after removing.
 *
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation:
 * Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 *
 * @author john.lim
 */
public class RemoveSubfolders {
  static List<String> removeSubfolders(String[] folders) {
    int n = folders.length;
    List<String> subFolders = new ArrayList<>();
    Arrays.sort(folders);
    for (int p = 0, i = 1; i <= n; i++) {
      if (i == n || !folders[i].startsWith(folders[p] + "/")) {
        subFolders.add(folders[p]);
        p = i;
      }
    }
    return subFolders;
  }

  public static void main(String[] args) {
    System.out.println(removeSubfolders(new String[] {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
    System.out.println(removeSubfolders(new String[] {"/a", "/a/b/c", "/a/b/d"}));
    System.out.println(removeSubfolders(new String[] {"/a/b/c", "/a/b/ca", "/a/b/d"}));
    System.out.println(removeSubfolders(new String[] {"/ah/al/am", "/ah/al"}));
    System.out.println(
        removeSubfolders(
            new String[] {
              "/abc/de",
              "/abc/dee",
              "/abc/def",
              "/abc/def/gh",
              "/abc/def/ghi",
              "/abc/def/ghij",
              "/abc/def/ghijk",
              "/abc/dez"
            }));
  }
}
