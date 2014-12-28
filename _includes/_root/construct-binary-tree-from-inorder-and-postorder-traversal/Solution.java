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
    
    int[] inorder;
    int[] postorder;
    int p;
    
    TreeNode buildTree(int st, int ed){
        
        if(st >= ed) return null;
        
        TreeNode root = new TreeNode(postorder[p]);
        
        int i;
        for(i = st ; i< ed && inorder[i] != postorder[p] ; i++);

        p--;
        root.right = buildTree(i + 1, ed);
        root.left = buildTree(st, i);
    
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.p = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        
        return buildTree(0, inorder.length);
    }
}