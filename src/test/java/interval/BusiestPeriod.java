package interval;

/*
Given an array, data, of data points,
 write a function findBusiestPeriod that returns the time at which the mall reached its busiest moment last year.
  The return value is the timestamp, e.g. 1480640292.
  Note that if there is more than one period with the same visitor peak, return the earliest one.

Assume that the array data is sorted in an ascending order by the timestamp.
 Explain your solution and analyze its time and space complexities.

Example:

input:  data = [ [1487799425, 14, 1],
                 [1487799425, 4,  0],
                 [1487799425, 2,  0],
                 [1487800378, 10, 1],
                 [1487801478, 18, 0],
                 [1487801478, 18, 1],
                 [1487901013, 1,  0],
                 [1487901211, 7,  1],
                 [1487901211, 7,  0] ]

output: 1487800378
 */
public class BusiestPeriod {
  static int findBusiestPeriod(int[][] a) {
    // your code goes here
    int max = 0;
    int ts = 0;
    int num = 0;

    int people = a[0][1];
    if (a[0][2] == 1) num += people;
    else num -= people;

    for (int i = 1; i < a.length; i++) {
      if (a[i][0] != a[i - 1][0]) {
        if (max < num) {
          max = num;
          ts = a[i - 1][0]; // 8
        }
      }
      people = a[i][1];
      if (a[i][2] == 1) num += people; // + 10
      else num -= people;
    }
    if (max < num) {
      max = num;
      ts = a[a.length - 1][0];
    }
    // 1487901211, 7,  0
    return ts;
  }

  public static void main(String[] args) {
    System.out.println(
        findBusiestPeriod(
            new int[][] {
              {1487799425, 14, 1},
              {1487799425, 4, 0},
              {1487799425, 2, 0},
              {1487800378, 10, 1},
              {1487801478, 18, 0},
              {1487801478, 18, 1},
              {1487901013, 1, 0},
              {1487901211, 7, 1},
              {1487901211, 7, 0}
            }));
    System.out.println(
        findBusiestPeriod(
            new int[][] {
              {1487799425, 14, 1},
              {1487799425, 4, 1},
              {1487799425, 2, 1},
              {1487800378, 10, 1},
              {1487801478, 18, 1},
              {1487901013, 1, 1},
              {1487901211, 7, 1},
              {1487901211, 7, 1}
            }));

    System.out.println(findBusiestPeriod(new int[][] {{1487799426, 21, 1}}));
    System.out.println(
        findBusiestPeriod(
            new int[][] {
              {1487799425, 21, 0},
              {1487799427, 22, 1},
              {1487901318, 7, 0}
            }));
  }
}
