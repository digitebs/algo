package string;

public class NumberToWords {
  String[] lookup =
      new String[] {
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
      };

  public StringBuilder hundred(int r) {

    int d = r / 100;
    StringBuilder sb = new StringBuilder();
    if (d > 0) {
      sb.append(" ").append(lookup[d]).append(" Hundred");
      r = r % 100;
    }

    d = r / 10;
    if (d > 1) {
      sb.append(" ").append(lookup[d + 18]);
      r = r % 10;
    }

    if (!lookup[r].isEmpty()) sb.append(" ").append(lookup[r]);
    return sb;
  }

  public String numberToWords(int r) {
    // billion
    StringBuilder sb = new StringBuilder();

    if (r == 0) return "Zero";

    int d = r / 1000000000;
    if (d > 0) {
      sb.append(hundred(d)).append(" Billion");
      r = r % 1000000000;
    }

    d = r / 1000000;
    if (d > 0) {
      sb.append(hundred(d)).append(" Million");
      r = r % 1000000;
    }

    d = r / 1000;
    if (d > 0) {
      sb.append(hundred(d)).append(" Thousand");
      r = r % 1000;
    }

    return sb.append(hundred(r)).toString().trim();
  }

  public static void main(String[] args) {
    System.out.println(new NumberToWords().numberToWords(100000));
    System.out.println(new NumberToWords().numberToWords(143));
    System.out.println(new NumberToWords().numberToWords(12345));
    System.out.println(new NumberToWords().numberToWords(0));
  }
}
