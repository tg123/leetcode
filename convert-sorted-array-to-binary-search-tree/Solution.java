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
    
    //TreeNode
    
    public TreeNode sortedArrayToBST(int[] num) {
        
        if(num.length == 0)
            return null;
        
        if(num.length == 1)
            return new TreeNode(num[0]);
        
        int mid = num.length / 2;
        
        TreeNode root = new TreeNode(num[mid]);
        
        root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1, num.length));
        
        return root;
        
    }
}