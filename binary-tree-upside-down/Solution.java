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
    
    LinkedList<TreeNode> queue = new LinkedList<>();
    
    void inOrder(TreeNode root){

        if(root == null) return;

        inOrder(root.left);

        queue.add(root);

        if(root.left != null) {
            queue.add(root.right);
        }


        // bad side effect
        root.left  = null;
        root.right = null;
    }
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        inOrder(root);
        
        TreeNode newRoot = queue.poll();
        
        root = newRoot;
        
        while(!queue.isEmpty()){
            root.right = queue.poll();
            root.left  = queue.poll();

            root = root.right;
        }
        
        return newRoot;
    }
}
