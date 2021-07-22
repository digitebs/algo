package oo;

import java.util.*;

public class CrepeCart {
  int[] xpos;
  int[] ypos;

  CrepeCart(int q) {
    xpos = new int[q + 1];
    ypos = new int[q + 1]; // clear
  }

  private void forward(int[] arr, int pos) {
    for (int i = pos; i < arr.length; i++) arr[i]++;
  }

  private void backward(int[] arr, int pos) {
    for (int i = pos; i >= 0; i--) arr[i]++;
  }

  private void push(int x, int y, char d) {
    switch (d) {
      case 'N':
        y++;
        forward(ypos, y);
        break;
      case 'S':
        y--;
        backward(ypos, y);
        break;
      case 'E':
        x++;
        forward(xpos, x);
        break;
      case 'W':
        x--;
        backward(xpos, x);
        break;
    }
  }

  private int[] count() {
    int maxX = 0;
    int maxY = 0;
    int x = 0;
    int y = 0;
    for (int i = 0; i < xpos.length; i++) {
      if (maxX < xpos[i]) {
        maxX = xpos[i];
        x = i;
      }

      if (maxY < ypos[i]) {
        maxY = ypos[i];
        y = i;
      }
    }

    return new int[] {x, y};
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 1; i <= t; ++i) {
      int p = scan.nextInt();
      int q = scan.nextInt();
      CrepeCart cc = new CrepeCart(q);
      while (p-- > 0) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        char d = scan.next().charAt(0);
        cc.push(x, y, d);
      }
      int[] res = cc.count();
      System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
      /* long start = System.currentTimeMillis();
      int[] res = pair(m);
      System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
      System.out.println(System.currentTimeMillis() - start);*/
      // hmm brute force?
    }
  }
}
