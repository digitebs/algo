package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
    You are a waiter at a party. There are  stacked plates on pile .
    Each plate has a number written on it. Then there will be Q iterations. In i-th iteration,
    you start picking up the plates in  from the top one by one and check whether the number
    written on the plate is divisible by the -th prime. If the number is divisible, you stack that plate on pile Bi.
    Otherwise, you stack that plate on pile Ai. After  iterations, plates can only be on pile B1 B2.. BQ,AQ.
    Output numbers on these plates from top to bottom of each piles in order of B1 B2.. BQ,AQ.

    ======================================
    Sample Input 0
    5 1
    3 4 7 6 5
    Sample Output 0
    4
    6
    3
    7
    5
    ======================================
    Sample Input 1

    5 2
    3 3 4 4 9
    Sample Output 1

    4
    4
    9
    3
    3
*/
public class Waiter {
  private static boolean isPrime(int number) {
    int sqrt = (int) Math.sqrt(number) + 1;
    for (int i = 2; i < sqrt; i++) if (number % i == 0) return false;
    return true;
  }

  static int[] waiter(int[] number, int q) {
    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 2; primes.size() < q; i++) {
      if (isPrime(i)) primes.add(i);
    }
    Stack<Integer> a = new Stack();
    Stack<Integer> b = new Stack();
    for (int i = 0; i < number.length; i++) {
      a.push(number[i]); // push
    }
    int k = 0;
    for (int i = 0; i < q; i++) {
      Stack<Integer> temp = new Stack();
      int prime = primes.get(i);
      while (!a.isEmpty()) {
        int plate = a.pop();
        if (plate % prime == 0) b.push(plate);
        else temp.push(plate);
      }
      // System.out.println(a+" "+b);
      while (!b.isEmpty()) number[k++] = b.pop();
      a = temp; // a copies temp;
    }
    while (!a.isEmpty()) number[k++] = a.pop();
    return number;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(waiter(new int[] {3, 4, 7, 6, 5}, 1)));
    System.out.println(Arrays.toString(waiter(new int[] {3, 3, 4, 4, 9}, 2)));
  }
}
