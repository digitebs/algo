package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * class to find least common ancestor of 2 tree node
 */
public class TreeLCM {
    public boolean dfs(TreeNode root, TreeNode t, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == t) return true;
        if (root.left != null && dfs(root.left, t, path)) return true;
        if (root.right != null && dfs(root.right, t, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }
    List<TreeNode> path1, path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        dfs(root, p, path1);
        dfs(root, q, path2);
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++)
            if (path1.get(i) != path2.get(i)) break;
        return path1.get(i - 1);
    }
}
