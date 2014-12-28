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
    
    int last;
    boolean failed;
    
    void inorder(TreeNode root){
        
        if(root == null) return;
        if(failed) return;
        
        inorder(root.left);
        
        if( last >= root.val) failed = true;
        last = root.val;
        
        inorder(root.right);
        
    }
    
    public boolean isValidBST(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        last = Integer.MIN_VALUE;
        failed = false;
        
        if(root == null) return true;
        inorder(root);
        return !failed;
    }
}