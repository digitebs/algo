package string;

import java.util.ArrayList;
import java.util.List;

/** @author johnlim */
public class PrettyJSON {
  static List<String> prettyJSON(String a) {
    List<String> res = new ArrayList<>();

    String tabStr = "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);

      if (c == '[' || c == '{') { // next line tabcount+1
        res.add(tabStr + sb + c);
        tabStr += "\t";
        sb.setLength(0);
      } else if (c == ']' || c == '}') {
        if (sb.length() != 0) res.add(tabStr + sb);
        res.add((tabStr = tabStr.substring(0, tabStr.length() - 1)) + c);
        //tabStr = tabStr.substring(0, tabStr.length()-1);
        sb.setLength(0);
      } else if (c == ',') {
        if (a.charAt(i - 1) == ']' || a.charAt(i - 1) == '}')
          res.set(res.size() - 1, res.get(res.size() - 1) + c);
        else res.add(tabStr + sb + c);
        sb.setLength(0);
      } else if (c != ' ' || sb.length() != 0) sb.append(c);
    }

    return res;
  }

  public static void main(String[] args) {
    List<String> lines =
        prettyJSON("[\"foo\": {\"bar\": [\"name\":\"baz\",null,1.0,2,\"hello:world\"]}]");
    lines.forEach(System.out::println);
  }
}
