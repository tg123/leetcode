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
    
    public int minDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(root == null) return 0;
        else if(root.left == null && root.right == null) return 1; //leaf
        else{
            int ml = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
            int rl = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
            return Math.min(rl, ml) + 1;
        }
    }
}