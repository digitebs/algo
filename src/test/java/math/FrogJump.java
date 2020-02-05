package math;

import static java.lang.System.out;

class FrogJump {
  int jump(int X, int Y, int D) {
    return (Y - X) / D + ((Y - X) % D == 0 ? 0 : 1);
  }

  public static void main(String[] args) {
    FrogJump fj = new FrogJump();
    out.println(fj.jump(1, 5, 2));
    out.println(fj.jump(2, 6, 4));
  }
}
