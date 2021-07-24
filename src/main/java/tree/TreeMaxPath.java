package tree;

import model.Node;

import java.util.ArrayList;

public class TreeMaxPath {

  public static int print(Node node, ArrayList path) {
    if (node == null) {
      return 0;
    }

    path.add(node.val);

    if (node.left == null && node.right == null) {

      System.out.println(path);
      return (int) path.stream().distinct().count();
    } else {
      return Math.max(
          print(node.left, new ArrayList(path)), print(node.right, new ArrayList(path)));
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(2);
    root.left.right = new Node(5);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.right.right = new Node(8);
    System.out.println(print(root, new ArrayList()));
    // System.out.println();
    // System.out.println(solutionStack("(())))("));
    /**
     * System.out.println(solutionPassowrd("a0Baa33a"));
     * System.out.println(solutionPassowrd("a0Ba")); System.out.println(solutionPassowrd("a00a"));
     * System.out.println(solutionPassowrd("00a")); System.out.println(solutionPassowrd("a00"));
     * System.out.println(solutionPassowrd("00")); System.out.println(solutionPassowrd("aa"));*
     */
  }
}
