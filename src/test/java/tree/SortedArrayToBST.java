package tree;

import model.TreeNode;

/*
 Given an integer array nums where the elements are sorted in ascending order,
 convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every
node never differs by more than one.
 */
public class SortedArrayToBST {
  public void merge(TreeNode t, int[] nums, int lo, int hi) {


    int mid = (hi + lo) / 2;
    // System.out.println("high:"+hi+" lo:"+lo +" mid:"+mid +" "+ (mid+lo)/2 +" "+(mid+1+hi)/2);
    if (lo + 1 < hi)
    merge(t.left = new TreeNode(nums[(lo + mid) / 2]), nums, lo, mid);

    // System.out.println("shift" +mid);
    if (mid + 1 < hi)
    merge(t.right= new TreeNode(nums[(mid + 1 + hi) / 2]), nums, mid + 1, hi);
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    int n = nums.length;
    int mid = n / 2;
    TreeNode root = new TreeNode(nums[mid]);
    merge(root, nums, 0, n);

    return root;
  }
}
