package time;

public class TimeString {
  // From grab
  public int solution(String E, String L) {
    // write your code in Java SE 8
    String[] t1 = E.split(":");
    String[] t2 = L.split(":");
    int hh1 = Integer.parseInt(t1[0]);
    int mm1 = Integer.parseInt(t1[1]);

    int hh2 = Integer.parseInt(t2[0]);
    int mm2 = Integer.parseInt(t2[1]);

    int hh = hh2 - hh1;
    int mm = mm2 - mm1;
    if (mm > 0) hh += 1;
    int cost = 2;
    if (hh >= 1) cost += 3;
    cost += (hh - 1) * 4;
    return cost;
  }

  public static void main(String[] args) {
    TimeString s = new TimeString();
    System.out.println(s.solution("10:00", "13:21"));
  }
}
