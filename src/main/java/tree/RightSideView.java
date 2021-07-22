package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class RightSideView {
  List<Integer> res = new ArrayList<>();

  public void preorder(TreeNode root, int level) {

    if (root == null) return;
    if (res.size() <= level) res.add(root.val);
    else res.set(level, root.val);

    preorder(root.left, level + 1);
    preorder(root.right, level + 1);
  }

  public List<Integer> rightSideView(TreeNode root) {
    preorder(root, 0);
    return res;
  }
}
