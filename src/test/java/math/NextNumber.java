package math;

/** @author john.lim 2-> 5 -> 25 -> 52 -> 55 -> 222... */
public class NextNumber {

  public String nextNumber(String num) {
        char[] numchar = num.toCharArray();
      if (num.indexOf("2") == -1) {
          for (int i = 0; i < num.length(); i++) numchar[i] ='2';
          return '2' + new String(numchar);
      }


    for (int i = num.length() - 1; i >= 0; i--) {
      if (numchar[i] == '2') {
          numchar[i]='5';
        break;
      } else if (numchar[i] == '5')   numchar[i]='2';
    }

    return new String(numchar);
  }

  public static void main(String[] args) {
    NextNumber nn = new NextNumber();
    System.out.println(nn.nextNumber("25"));
    System.out.println(nn.nextNumber("222"));
    System.out.println(nn.nextNumber("52"));
    //
  }
}
