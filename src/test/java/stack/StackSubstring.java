package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackSubstring {

  // Stack<Integer>[] stacks = new Stack[5];
  int stackSubstring(Stack<Integer>[] stacks, int j, int pos) {
    if (pos == 0) return 0;
    if (j == stacks.length) return 0;
    //  System.out.println(j+ " "+pos+" "+stacks[j].size());
    //  if(j == stacks.length && stacks[j].size() < pos) return 0;
    int val = 0;
    int max = 0;
    for (int i = 0; i < Math.min(pos,stacks[j].size()); i++) {
      int num = stacks[j].get(stacks[j].size()-i-1);
        val += num;
       System.out.println(i+" "+ " num:"+num+" val:"+val+" pos:"+ pos);
      max = Math.max(val + stackSubstring(stacks, j + 1, pos-1-i), max);
     // stacks[j].push(num); // backtracking
    }
      System.out.println("hh"+max);
    return max;
  }

  public static void main(String[] args) {
    //
    StackSubstring ss = new StackSubstring();
    Stack<Integer>[] s = new Stack[2];
    s[0] = new Stack<Integer>();
    s[0].push(30);
    s[0].push(100);
    s[0].push(10);
    s[0].push(10);

    s[1] = new Stack<Integer>();
    s[1].push(50);
    s[1].push(10);
    s[1].push(50);
    s[1].push(80);


      s = new Stack[3];
      s[0] = new Stack<Integer>();
      s[0].push(1);
      s[0].push(1);

      s[1] = new Stack<Integer>();
      s[1].push(1);
      s[1].push(1);

      s[2] = new Stack<Integer>();
      s[2].push(1);
      s[2].push(1);

    // System.out.println(stackSubstring(s,0, 5));
      /*s = new Stack[3];
    s[0] = new Stack<Integer>();
    s[0].push(80);
    s[0].push(80);

    s[1] = new Stack<Integer>();
    s[1].push(50);
    s[1].push(15);

    s[2] = new Stack<Integer>();
    s[2].push(10);
    s[2].push(20);*/

    ArrayList<Stack[]> res = new ArrayList<>();
    ss.combine(res, s, 0);

    int max = 0;
    for (Stack[] r : res) {
      System.out.println(Arrays.toString(r));
      max = Math.max(ss.stackSubstring(r, 0, 1), max);
    }

    System.out.println(max);
    /* System.out.println(stackSubstring(s,0, 3));
    System.out.println(stackSubstring(s,0, 3));
    System.out.println(stackSubstring(s,0, 3));
    System.out.println(stackSubstring(s,0, 3));
    System.out.println(stackSubstring(s,0, 3));*/

  }

  void swap(int i, int j, Stack[] s) {
    Stack temp = s[i];
    s[i] = s[j];
    s[j] = temp;
  }

  void combine(ArrayList<Stack[]> res, Stack[] arr, int pos) {
    if (pos == arr.length) {
      res.add(arr.clone());
    } else {
      for (int j = pos; j < arr.length; j++) {
        swap(pos, j, arr);
        combine(res, arr, pos + 1);
        swap(pos, j, arr); // backtrack
      }
    }
  }
}
