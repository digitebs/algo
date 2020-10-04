package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class AnswerQuery {
  class Query {
    int type;
    int index;

    Query(int type, int index) {
      this.type = type;
      this.index = index;
    }
  }

  int[] answerQueries(ArrayList<Query> queries, int n) {

    TreeSet<Integer> ts = new TreeSet<>();
    int m = queries.size();
    boolean[] arr = new boolean[n];
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      Query q = queries.get(i);
      if (q.type == 1) {
        arr[q.index] = true;
        ts.add(q.index);
      } else {
        res.add(ts.contains(q.index) ? q.index : ts.floor(q.index));
      }
    }
    return res.stream().mapToInt(x -> x == null ? -1 : x).toArray();
  }

  public static void main(String[] args) {
    AnswerQuery aq = new AnswerQuery();
    ArrayList<Query> q = new ArrayList<>();
    q.add(aq.new Query(2, 3));
    q.add(aq.new Query(1, 3));
    q.add(aq.new Query(1, 4));
    q.add(aq.new Query(2, 3));
    System.out.println(Arrays.toString(aq.answerQueries(q, 5)));
  }
}
