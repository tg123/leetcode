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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> rt = new ArrayList<Integer>();

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        
        if(root != null)
            stack.push(root);
        
        //TreeNode current = root;
        
        
        while(!stack.isEmpty()){
            
            TreeNode current = stack.pop();
            rt.add(current.val);
            
            
            if(current.right != null)
                stack.push(current.right);

            if(current.left != null)
                stack.push(current.left);
                
        }
        
        
        return rt;
        
    }
}