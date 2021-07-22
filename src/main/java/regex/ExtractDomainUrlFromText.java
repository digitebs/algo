package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDomainUrlFromText {

  // url extractor for a bunch of text
  public static List<String> extractUrls(String text) {
    List<String> containedUrls = new ArrayList<>();
    String urlRegex =
        "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
    Matcher urlMatcher = pattern.matcher(text);

    while (urlMatcher.find()) {
      containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
    }

    return containedUrls;
  }

  static void getUrlDomain(String str) {
    Pattern p = Pattern.compile(".*https*://(www.|ww2.|web.)?(.*([;]|\\b)*)");
    Matcher m = p.matcher(str);

    int start = 0;
    while (m.find(start)) {
      String s = m.group(2);
      System.out.println(s);
      System.out.println(s.split("\\/")[0]);
      start = m.end(2);
      System.out.println(start);
    }
  }

  static void testRegex2(String str) {
    Pattern p = Pattern.compile("fg");
    Matcher m = p.matcher(str);

    while (m.find()) {
      System.out.println(m.end());
    }
  }

  public static void main(String args[]) {

    getUrlDomain("https://web.xyz.com;https://web.xyz.com");
    // testRegex2("fgfgfg");
  }
}
