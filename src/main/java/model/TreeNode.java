package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public List<Integer> toList(){
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(this);
    while (!q.isEmpty()){
      TreeNode node = q.poll();
      res.add(node.val);
      if(node.left!=null) q.offer(node.left);
      if(node.right!=null) q.offer(node.right);
    }
    return res;
  }

}
