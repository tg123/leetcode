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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Deque<Integer> rt = new LinkedList<Integer>();

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        
        if(root != null)
            stack.push(root);
        
        while(!stack.isEmpty()){
            
            TreeNode current = stack.pop();
            rt.push(current.val);


            if(current.left != null)
                stack.push(current.left);            
            
            if(current.right != null)
                stack.push(current.right);

                
        }
        
        
        return new ArrayList<Integer>(rt);
    }
}