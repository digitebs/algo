package string;

import java.util.ArrayList;

import static java.lang.System.out;

public class PrettyJSON {
  static ArrayList<String> prettyJSON(String a) {
    ArrayList<String> res = new ArrayList<>();

    String tabStr = "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);

      if (c == '[' || c == '{') { // next line tabcount+1
        if (sb.length() == 0) res.add(tabStr + sb);
        res.add(tabStr + c);
        sb.setLength(0);
        tabStr += "\t";
      } else if (c == ']' || c == '}') {
        if (sb.length() == 0) res.add(tabStr + sb);
        res.add((tabStr = tabStr.substring(0, tabStr.length() - 1)) + c);
        sb.setLength(0);
      } else if (c == ',') {
        if (a.charAt(i - 1) == ']' || a.charAt(i - 1) == '}')
          res.set(res.size() - 1, res.get(res.size() - 1) + c);
        else res.add(tabStr + sb + c);
        sb.setLength(0);
      } else sb.append(c);
    }

    return res;
  }

  public static void main(String[] args) {
    ArrayList<String> lines = prettyJSON("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]");
    for (String l : lines) {
      out.println(l);
    }
  }
}
