package tree;

import model.Node;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public List<Node> generateTrees(int n) {
        return generate(1, n);
    }

    /*
         recursion with new instance merge back up

        the recursion generates new list each time. but return it back to the top.
        its a recursion where the result from bottom is merge back up in the returned
        instead of the parameter
     */
    private List<Node> generate(int start, int end) {
        List<Node> list = new ArrayList<>(); // its anew list each time
        if (start > end) return list;
        if (start == end) {
            list.add(new Node(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<Node> left = generate(start, i - 1);
            List<Node> right = generate(i + 1, end);
            if (left.size() == 0) {
                for (Node r : right) {
                    Node t = new Node(i);
                    t.right = r;
                    list.add(t);
                }
            }
            /*
             need to copy all possible combination
             */
            for (Node l : left) {
                for (Node r : right) {
                    Node t = new Node(i);
                    t.left = l;
                    t.right = r;
                    list.add(t);
                }
            }
            if (right.size() == 0) {
                for (Node l : left) {
                    Node t = new Node(i);
                    t.left = l;
                    list.add(t);
                }
            }
        }
        return list;
    }
}
