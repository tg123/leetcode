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
    
    int height(TreeNode root){
        if(root == null)
        return 0;
        else
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(root == null) return true;
        
        return 
        Math.abs(height(root.left) - height(root.right)) <=1 &&
        isBalanced(root.left) && isBalanced(root.right);
        
        //return isBalanced()
    }
}