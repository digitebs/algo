package recursion;

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {

  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    HashMap<String, String> res = new HashMap<>();
    for (Map.Entry<String, Object> e : dict.entrySet()) {
      res.putAll(flattenDictionary(e.getKey(), e.getValue()));
    }
    return res;
  }

  static HashMap<String, String> flattenDictionary(String key, Object value) {
    HashMap<String, String> res = new HashMap<>();
    if (value instanceof String s  || value instanceof Integer i) {
      res.put(key, value.toString());
    } else {
      HashMap<String, Object> v = (HashMap<String, Object>) value;
      for (Map.Entry<String, Object> e : v.entrySet()) {
        res.putAll(
            flattenDictionary(key + (e.getKey().equals("") ? "" : ".") + e.getKey(), e.getValue()));
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // flattenDictionary()

    HashMap<String, Object> hm1 = new HashMap<>();
    hm1.put("Key3", "a");

    HashMap<String, Object> hm = new HashMap<>();
    hm.put("Key1", "a");
    hm.put("Key2", hm1);
    System.out.println(flattenDictionary(hm));
  }
}
