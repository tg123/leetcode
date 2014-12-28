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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        ArrayList<List<Integer>> rt = new ArrayList<List<Integer>>();
        
        if(root == null) return rt;

        final TreeNode END = new TreeNode(0);
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        queue.add(END);
        
        boolean direction = true; // true for left -> right , false for right -> left
        
        Deque<Integer> level = new LinkedList<Integer>();
        
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            if(current == END){
                
                direction = !direction;
                rt.add(new ArrayList<Integer>(level)); // copy
                
                level.clear();
                
                if(!queue.isEmpty()) queue.add(END);
                
            }else{
                
                if(direction){ // true for left -> right , false for right -> left
                    level.addLast(current.val);
                }else{
                   level.addFirst(current.val);
                }
                
                
                if(current.left  != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                
            }
        }
        
        return rt;
        
    }
}
