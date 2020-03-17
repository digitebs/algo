import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** Created by johnlim on 10/2/16. */
public class Solution {
  public static void main(String args[]) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");

    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      System.out.println(string);
    }

    System.out.println(
        BigDecimal.valueOf(1).divide(BigDecimal.valueOf(60), 5, BigDecimal.ROUND_UP));
  }

  int runnersMeetings(int[] dist2, int[] speed) {
    int[] pos =
        IntStream.range(0, speed.length)
            .boxed()
            .sorted(
                (a, b) -> {
                  return speed[a] - speed[b];
                })
            .mapToInt(x -> x)
            .toArray();

    BigDecimal[] dist = new BigDecimal[dist2.length];
    for (int i = 0; i < dist2.length; i++) dist[i] = new BigDecimal(dist2[i]);
    int max = 1;
    while (true) { // run infinitely

      int card = 1;
      int flag = 1;

      //   System.out.println(new BigDecimal(1.0).divide(new BigDecimal(60)));
      dist[pos[0]] =
          BigDecimal.valueOf(speed[pos[0]])
              .divide(BigDecimal.valueOf(60.), 4, BigDecimal.ROUND_HALF_UP)
              .add(dist[pos[0]]);
      // System.out.println("2222");
      HashMap<Float, Integer> hm = new HashMap<>();
      for (int i = 1; i < pos.length; i++) {
        dist[pos[i]] =
            dist[pos[i]].add(
                 BigDecimal.valueOf(speed[pos[i]])
                    .divide(BigDecimal.valueOf(60.), 4, BigDecimal.ROUND_HALF_UP));
        // System.out.println(Arrays.toString(dist));
        if (Math.abs(dist[pos[i - 1]].subtract(dist[pos[i]]).floatValue()) < 0.0001f) {

          float key = dist[pos[i]].setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
          hm.put(key, hm.getOrDefault(key, 1) + 1);
          card = Math.max(hm.get(key), card);
          //       System.out.println(Arrays.toString(dist)+ " "+key);
          // card++;
        }
        if (dist[pos[i - 1]].subtract(dist[pos[i]]).floatValue() < 0
            || speed[pos[i]] == speed[pos[i - 1]]) {
          // System.out.println(Arrays.toString(dist));
          flag++;
        }
      }
      max = Math.max(card, max); // match all
      if (flag >= pos.length) return max == 1 ? -1 : max;
    }
  }
}
