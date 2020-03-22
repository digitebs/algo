package array;

/*

    easy*

    I have two registers: one for take-out orders, and the other for the other folks eating inside the cafe.
    given an array of take out orders and dine in orders. check whether the served orders are in first come first serve

   Input:
       Take Out Orders: [1, 3, 5]
       Dine In Orders: [2, 4, 6]
       Served Orders: [1, 2, 4, 6, 5, 3]
   Output: false

   Input:
     Take Out Orders: [1, 3, 5]
     Dine In Orders: [2, 4, 6]
     Served Orders: [1, 2, 3, 5, 4, 6]

    Output: true
*/
public class FirstComeFirstServe {
  boolean isFirstComeFirstServed(int[] a, int[] b, int[] c) {

    int j = 0;
    int i = 0;
    // check if we're serving orders first-come, first-served
    for (int num : c) {
      if (i < a.length && a[i] == num) i++;
      else if (j < b.length && b[j] == num) j++;
      else return false;
    }

    return i == a.length && j == b.length;
  }

  public static void main(String[] args) {
    FirstComeFirstServe fcfs = new FirstComeFirstServe();
    System.out.println(
        fcfs.isFirstComeFirstServed(new int[] {1, 9}, new int[] {7, 8}, new int[] {1, 7, 8}));
  }
}
