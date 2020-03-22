package math;

import com.sun.tools.corba.se.idl.constExpr.Plus;
import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static java.lang.System.out;


/*
  given a non negative array, add 1 to the array.

  Input:  1,2,3
  Output: 1,2,4
 */
public class PlusOne {
  ArrayList<Integer> plusOne(ArrayList<Integer> a) {
    for (int i = a.size() - 1; i >= 0; i--) {
      if (a.get(i) == 9) { // okay we will exceed 10
        a.set(i, 0);
        if (i == 0) a.add(0, 1);
      } else {
        a.set(i, a.get(i) + 1);
        break; // stop
      }
    }

    while (a.size() > 1 && a.get(0) == 0) {
      a.remove(0);
    }
    return a;
  }

  public static void main(String[] args) {
    PlusOne po = new PlusOne();
    out.println(po.plusOne(new ArrayList<>(Arrays.asList(1, 2))));
    out.println(po.plusOne(new ArrayList<>(Arrays.asList(9, 9, 9))));
    out.println(po.plusOne(new ArrayList<>(Arrays.asList(0, 9, 9))));
  }
}
