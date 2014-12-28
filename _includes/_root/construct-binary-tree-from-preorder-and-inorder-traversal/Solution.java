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
    
    int p = 0;
    int[] preorder;
    int[] inorder;
    
    
    TreeNode buildTree(int st, int ed){
        
        if(st >= ed) return null; //
        
        TreeNode root = new TreeNode(preorder[p]);
        
        int i;
        for(i = st ; i< ed && inorder[i] != preorder[p] ; i++);

        p++;
        root.left = buildTree(st, i);
        root.right = buildTree(i + 1, ed);
        
        return root;
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        this.preorder = preorder;
        this.inorder = inorder;
        this.p = 0;
        //if (preorder.length == 0) return null;
        return buildTree(0 , inorder.length);
        //return new TreeNode(preorder[p]);
    }
}