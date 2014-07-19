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
    
    ArrayList<Integer> r;
    
    void inorder(TreeNode root){
        
        if(root == null) return;
        
        inorder(root.left);
        r.add(root.val);
        inorder(root.right);
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        r = new ArrayList<Integer>();
        
        inorder(root);
        return r;
    }
}