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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> rt = new  ArrayList<ArrayList<Integer>>();
        
        if(root == null) return rt;
        
        final TreeNode END = new TreeNode(0);
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.addLast(root);
        queue.addLast(END);
        
        while(queue.getFirst() != END){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            
            TreeNode node = queue.removeFirst();
            
            while(node != END){
                
                cur.add(node.val);
                
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
                
                node = queue.removeFirst();
            }
            
            
            rt.add(cur);
            queue.addLast(END);
        }
        
        return rt;
        
    }
}