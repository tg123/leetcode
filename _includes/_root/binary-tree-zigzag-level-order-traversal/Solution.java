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
    
    static final TreeNode END = new TreeNode(0);
    
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        
        
        ArrayList<ArrayList<Integer>> rt = new ArrayList<ArrayList<Integer>>();
        
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        queue.add(END);
        
        boolean direction = true; // true for left -> right , false for right -> left
        
        while(queue.peek() != END){
            
            TreeNode current = queue.poll();
            
            Deque<Integer> level = new LinkedList<Integer>();
            
            while(current != END){
                
                if(direction){ // true for left -> right , false for right -> left
                    level.addLast(current.val);
                }else{
                   level.addFirst(current.val);
                }
                
                
                if(current.left  != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                
                current = queue.poll();
            }
            
            queue.add(END);
            
            direction = !direction;
            
            rt.add(new ArrayList<Integer>(level));
        }
        
        return rt;
        
    }
}