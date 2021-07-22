package math;

/*
   add 2 numbers without carry
*/
public class AdditionWithoutCarry {
  int additionWithoutCarrying(int param1, int param2) {
    int ans = 0;
    int f = 1;
    while (param1 > 0 || param2 > 0) {
      int r1 = param1 % 10;
      int r2 = param2 % 10;
      ans = ans + f * ((r1 + r2) % 10);
      f = f * 10;
      param1 = param1 / 10;
      param2 = param2 / 10;
    }
    return ans;
  }

  public static void main(String[] args) {
    AdditionWithoutCarry awc = new AdditionWithoutCarry();
    System.out.println(awc.additionWithoutCarrying(9999, 0));
    System.out.println(awc.additionWithoutCarrying(456, 1734));
  }
}
