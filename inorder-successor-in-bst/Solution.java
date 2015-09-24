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

    TreeNode leftMost(TreeNode root){
        if(root == null) return null;
        if(root.left != null) return leftMost(root.left);
        return root;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == p) {
            return leftMost(p.right);
        }

        if(p.val < root.val) {
            p = inorderSuccessor(root.left, p);

            if(p == null){
                return root;
            }

            return p;
        }

        return inorderSuccessor(root.right, p);
    }
}
