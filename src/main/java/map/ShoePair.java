package map;

import java.util.stream.IntStream;

/*
   Yesterday you found some shoes in the back of your closet. Each shoe is described by two values:

    - type indicates if it's a left(0) or a right(1) shoe;
   - id is the serial id of the shoe.

   Your task is to check whether it is possible to pair the shoes you found in such a way that each pair
   consists of a right and a left shoe of the same id.

   Input:
   shoes = [[0, 21],
          [1, 23],
         [1, 21],
         [0, 23]]

  Output: true


*/
public class ShoePair {

  boolean pairOfShoes(int[][] shoes) {
    int[] map = new int[101]; // paired hundred

    for (int[] s : shoes) {
      if (s[0] == 0) map[s[1]]++;
      else {
        map[s[1]]--;
      }
    }
    for (int m : map) {
      if (m != 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    ShoePair sp = new ShoePair();

    System.out.println(sp.pairOfShoes(new int[][] {{0, 21}, {1, 23}, {1, 21}, {0, 23}}));

    System.out.println(
        sp.pairOfShoes(
            new int[][] {
              {1, 25}, {0, 100}, {1, 1}, {1, 1}, {0, 25}, {0, 1}, {0, 100}, {1, 1}, {1, 100},
              {0, 25}, {0, 1}, {0, 100}, {1, 25}, {0, 1}
            }));
  }
}
