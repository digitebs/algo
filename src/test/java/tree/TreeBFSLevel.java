package tree;

import model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeBFSLevel {

    static List<List<Node>>  buildNodeLevel(Node root, int[][] indexes) {
        List<List<Node>> levels = new LinkedList<>();
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        for (int i = 0; i < indexes.length; ) {
            List<Node> level = new ArrayList<>(q.size());
            levels.add(level);

            // this is the trick to get depth at q, by making a copy of the current q contents
            for (Node node : new ArrayList  <>(q)) {
                level.add(node);
                if (indexes[i][0] != -1)
                    q.offer(node.left = new Node(indexes[i][0]));
                if (indexes[i][1] != -1)
                    q.offer(node.right = new Node(indexes[i][1]));
                i++;
                q.poll();
            }
        }
        return levels;
    }

    static void traverse(Node root, List<Integer> res) {
        if (root == null) return;
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Node root = new Node(1);
        List<List<Node>> levels = buildNodeLevel(root,indexes);
        int[][] swap = new int[queries.length][queries.length];
        for (int j = 0; j < queries.length; j++) {
            for (int i = 0; i < levels.size(); i++) {
                if ((i + 1) % queries[j] == 0) { //if its a factor we swap
                    for (Node level : levels.get(i)) {
                        Node temp = level.left;
                        level.left = level.right;
                        level.right = temp; // swap for each of parents
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            traverse(root, res);
            swap[j] = res.stream().mapToInt(Integer::intValue).toArray();
        }
        return swap;
    }
}
