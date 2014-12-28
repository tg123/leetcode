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
    
    
    
    public boolean hasPathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (root == null)
            return false;
            
        if (root.left == null && root.right == null) //leaf
            return root.val == sum;
        
        return (root.left  != null && hasPathSum(root.left, sum - root.val))
            || (root.right != null && hasPathSum(root.right, sum - root.val));
    }
}