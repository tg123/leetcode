/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode newLeft  = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);

        root.left  = newLeft;
        root.right = newRight;

        return root;
    }
}
