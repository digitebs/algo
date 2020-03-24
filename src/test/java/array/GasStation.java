package array;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
 * from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once in the
 * clockwise direction, otherwise return -1.
 *
 * <p>gas = [1,2,3,4,5] cost = [3,4,5,1,2]
 *
 * <p>output: 3
 */
public class GasStation {
  // using sliding window against 2 arrays
  public static int canCompleteCircuit2(int[] gas, int[] cost) {
    int n = gas.length;
    int l = 0;
    int r = 0;
    int total = 0;

    while (l < n) {
      if (total < 0) {
        total -= gas[l];
        total += cost[l];
        l++;
      } else {
        if (r >= n && l == (r % n)) return l;
        total += gas[r % n];
        total -= cost[r % n];
        r++;
      }
    }
    return -1;
  }

  // brute force
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0, mygas = 0; j <= n && mygas >= 0; j++) {
        if (j == n) return i;
        mygas += gas[(i + j) % n];
        mygas -= cost[(i + j) % n];
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // int[] a = new int[]{959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114,
    // 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239,
    // 899, 659, 718, 738, 7, 209};
    // int[] b = new int[]{982, 934, 504, 226, 710, 775, 705, 545, 647, 760, 161, 185, 95, 554, 750,
    // 333, 773, 887, 279, 600, 9, 664, 555, 969, 203, 233, 440, 958, 399, 351, 393, 123, 367, 637,
    // 235, 134, 664, 688, 70, 885, 326, 45, 659, 240, 827, 892, 481, 80, 208, 441, 213, 586, 970,
    // 326, 960, 558, 563, 623, 177, 252, 598, 985, 18, 758, 496, 439, 622, 598, 97, 263, 275, 604,
    // 861, 454, 376, 872, 873, 239, 964, 321, 187, 261, 499, 195, 4, 443, 414, 785, 809, 632, 431,
    // 427, 271, 699, 699, 843, 33};

    int[] a = new int[] {1, 2};
    int[] b = new int[] {2, 1};

    // int[] a = new int[]{1, 2, 3, 4, 5};
    // int[] b = new int[]{3, 4, 5, 1, 2};
    System.out.println(canCompleteCircuit(a, b));
  }
}
