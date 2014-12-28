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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        ArrayList<List<Integer>> rt = new  ArrayList<List<Integer>>();
        
        if(root == null) return rt;
        
        final TreeNode END = new TreeNode(0);
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        queue.add(END);
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            
            TreeNode node = queue.poll();
            
            if(node == END){
                rt.add(new ArrayList<Integer>(level)); // copy
                level.clear();
                
                if(!queue.isEmpty()) queue.add(END);
                
            }else{
                
                level.add(node.val);
                                
                if(node.left != null)  queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
        }
        
        return rt;
        
    }
}
