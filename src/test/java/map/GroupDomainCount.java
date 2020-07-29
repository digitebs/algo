package map;

import java.util.HashMap;

/**
 given a string list of "click count , domain"

 return the sum of click count by domain,subdomain, 1st level, 2nd level etc...

 Input:
 [
 "900,google.com",
 "60,mail.yahoo.com",
 "10,mobile.sports.yahoo.com",
 "40,sports.yahoo.com",
 "300,yahoo.com",
 "10,stackoverflow.com",
 "20,overflow.com",
 "2,en.wikipedia.org",
 "1,m.wikipedia.org",
 "1,mobile.sports",
 "1,rakuten.co.jp" ,
 "1,google.co.jp"
 ]


 Output:
 {com=1340, stackoverflow.com=10, sports.yahoo.com=50, google.com=900, sports=1, org=3, rakuten.co.jp=1, wikipedia.org=3, jp=2, mobile.sports=1, co.jp=2, google.co.jp=1, mail.yahoo.com=60, en.wikipedia.org=2, mobile.sports.yahoo.com=10, yahoo.com=410, m.wikipedia.org=1, overflow.com=20}

 */
public class GroupDomainCount {
  static void test(String[] counts) {
    HashMap<String, Integer> hm = new HashMap<>();
    for (int i = 0; i < counts.length; i++) {
      String[] val = counts[i].split(",");
      int count = Integer.parseInt(val[0]);
      String tmp = val[1];

      int c = -1;
      do {
        tmp = tmp.substring(c + 1);
        if (!hm.containsKey(tmp)) hm.put(tmp, count);
        else hm.put(tmp, hm.get(tmp) + count);

      } while ((c = tmp.indexOf(".")) != -1);
    }

    System.out.println(hm);
  }

  public static void main(String[] args) {
    String[] counts = {
      "900,google.com",
      "60,mail.yahoo.com",
      "10,mobile.sports.yahoo.com",
      "40,sports.yahoo.com",
      "300,yahoo.com",
      "10,stackoverflow.com",
      "20,overflow.com",
      "2,en.wikipedia.org",
      "1,m.wikipedia.org",
      "1,mobile.sports",
      "1,rakuten.co.jp",
      "1,google.co.jp"
    };

    test(counts);
  }
}
