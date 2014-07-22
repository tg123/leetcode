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
    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(root == null) return 0;
        //if(root.left == null && root.right == null) return 1;
        else
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        
        
    }
}