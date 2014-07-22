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
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        
        Deque<ArrayList<Integer>> stack = new LinkedList<ArrayList<Integer>>();
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        queue.add(END);
        
        while(queue.peek() != END){
            
            TreeNode current = queue.poll();
            
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            while(current != END){
                level.add(current.val);
                
                if(current.left  != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                
                current = queue.poll();
            }
            
            queue.add(END);
            
            stack.push(level);
            
        }
        
        return new ArrayList<ArrayList<Integer>>(stack);
        
    }
}