/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
   TreeNode prev;

    void preorder(TreeNode root){
        
        if(root == null) return;
        
        TreeNode left  = root.left;
        TreeNode right = root.right;
        
        // root
        if(prev != null){
            prev.right = root;
            prev.left = null;
        }
        
        prev = root;
        
        preorder(left);
        preorder(right);
    }
    

    public void flatten(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        prev = null;
        preorder(root);
    }
}