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
    
    static final TreeNode EMPTY = new TreeNode(0);
    
    TreeNode nullToEmpty(TreeNode node){
        if(node == null) return EMPTY;
        
        return node;
    }
    
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        final TreeNode END = new TreeNode(0);
        
        LinkedList<TreeNode> level = new LinkedList<TreeNode>();
        
        level.add(nullToEmpty(root.left));
        level.add(nullToEmpty(root.right));
        
        queue.add(END);
        queue.add(nullToEmpty(root.left));
        queue.add(nullToEmpty(root.right));

        while(!queue.isEmpty()){
            
            TreeNode node = queue.poll();
            
            if(node == END){
                
                // check
                while(!level.isEmpty()){
                    TreeNode left  = level.pollFirst();
                    TreeNode right = level.pollLast();
                    
                    if(left == right) continue;
                    
                    if(left == EMPTY && right != EMPTY) return false; 
                    if(left != EMPTY && right == EMPTY) return false;
                    
                    if(left.val != right.val) return false;
                    
                }
                
                if(!queue.isEmpty()) queue.add(END);
                
            }else{
                
                level.add(node);
                
                if(node != EMPTY){
                    queue.add(nullToEmpty(node.left));
                    queue.add(nullToEmpty(node.right));
                }
            }
            
            
        }
        
        
        return true;
    }
}
