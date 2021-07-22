package tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.TreeNode;

/*

medium*

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 This path may or may not pass through the root.
 */
public class DiameterBinaryTree {

  int ans;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return ans;
  }

  public int depth(TreeNode node) {
    // recursive technique where you store in var 1st while computing the depth and return
    if (node == null) return 0;
    int L = depth(node.left);
    int R = depth(node.right);
    ans = Math.max(ans, L + R);
    return Math.max(L, R) + 1;
  }

  public static void main(String[] args) {
    TreeNode tn = new TreeNode(1);
    tn.left = new TreeNode(2);
    tn.right = new TreeNode(3);
    tn.left.left = new TreeNode(4);
    tn.left.right = new TreeNode(5);

    DiameterBinaryTree dbt = new DiameterBinaryTree();
    System.out.println(dbt.diameterOfBinaryTree(tn));
  }
}
