package sort;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author john.lim
 * sort the string by frequency of character, apPle == Ppael
 *
 * lexo order if its the same frequency, case sensitive
 */
public class FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c :s.toCharArray() ) {
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        return s.chars().mapToObj(c -> (char)c).sorted((a,b)->{
            int c = hm.get(b)  -  hm.get(a);
            return (c== 0)? a-b: c;
        }).map(String::valueOf).collect(Collectors.joining(""));
    }

  public static void main(String[] args) {
    //
      FrequencySort fs = new  FrequencySort();
      System.out.println(fs.frequencySort("tree"));
      System.out.println(fs.frequencySort("Aabb"));
      System.out.println(fs.frequencySort("apple"));
  }
}
