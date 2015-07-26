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

    TreeNode lca;

    TreeNode other;

    boolean containOther(TreeNode root){

        if(root == null) return false;

        if(root == other) return true;

        return containOther(root.left) || containOther(root.right);
    }

    void inorder(TreeNode root, TreeNode p, TreeNode q){
        if(lca != null) return;

        if(root == null) return;

        if(other == null) inorder(root.left,  p, q);

        if(other == null){
            if(root == p){
                other = q;
            } else if (root == q){
                other = p;
            }
        }

        if(other != null){
            // left contain one, need other
            if(root == other || containOther(root.right)){
                lca = root;
            }
        }

        if(other == null) inorder(root.right, p, q);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // a bit ugly
        inorder(root, p, q);

        return lca;
    }
}
