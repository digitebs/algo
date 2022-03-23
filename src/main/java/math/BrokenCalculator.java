package math;


/**
 * There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
 *
 * multiply the number on display by 2, or
 * subtract 1 from the number on display.
 * Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
 *
 *
 *
 * Example 1:
 *
 * Input: startValue = 2, target = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * Example 2:
 *
 * Input: startValue = 5, target = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * Example 3:
 *
 * Input: startValue = 3, target = 10
 * Output: 3
 * Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 *
 */
public class BrokenCalculator {
  public int brokenCalc(int start, int target) {
    // 9 100
    // 9 50
    // 9 25
    // 9 24
    // 9 12
    // 9 11
    // 9 3

    // 3 8
    // 3 4
    // 3 3
    int count =0;
    while(start < target){
      count++;
      if(target%2 ==1){
        target++;
      }else{
        target/=2;
      }
    }
    return count + start - target;
  }

  public static void main(String[] args) {
    var bc = new BrokenCalculator();
    System.out.println(bc.brokenCalc(2,3));
    System.out.println(bc.brokenCalc(5,8));
    System.out.println(bc.brokenCalc(3,10));
  }
}
