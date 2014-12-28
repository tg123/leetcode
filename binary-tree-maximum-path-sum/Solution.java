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
    
    int max;
    
    int sum(TreeNode root){
        if(root == null) return 0;
        
        int left  = sum(root.left);
        int right = sum(root.right);
        
        left  = Math.max(left, 0);
        right = Math.max(right, 0);
        
        int sum = root.val + left + right;
        max = Math.max(max, sum);
        
        return Math.max(left, right) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {

        max = Integer.MIN_VALUE;
        sum(root);
        
        return max;
    }
}