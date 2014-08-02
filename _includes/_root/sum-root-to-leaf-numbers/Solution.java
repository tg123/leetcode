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
    
    static class TreeNodeWithParent {
        TreeNode node;
        int parentval;
        
        TreeNodeWithParent(TreeNode node, int parentval){
            this.node = node;
            this.parentval = parentval;
        }
    }

    public int sumNumbers(TreeNode root) {
        
        if(root == null) return 0;
        
        final TreeNodeWithParent END = new TreeNodeWithParent(null ,0);
        
        LinkedList<TreeNodeWithParent> queue = new LinkedList<TreeNodeWithParent>();

        int sum = 0;
        
        queue.add(new TreeNodeWithParent(root, 0));
        queue.add(END);
        
        while(!queue.isEmpty()){
            
            TreeNodeWithParent c = queue.poll();
            
            if(c == END){
                
                if(!queue.isEmpty()){
                    queue.add(END);
                } 
                
            } else {
                
                int p = c.node.val + c.parentval * 10;
                
                if(c.node.left  == null && c.node.right == null){
                    sum += p; 
                    
                }else{
                    
                    if(c.node.left  != null) 
                        queue.add(new TreeNodeWithParent(c.node.left, p));
                        
                    if(c.node.right != null) 
                        queue.add(new TreeNodeWithParent(c.node.right, p));
                    
                }
                
            }
            
        }

        
        return sum;
    }
}
