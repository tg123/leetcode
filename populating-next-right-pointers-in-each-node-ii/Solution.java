/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    static final TreeLinkNode ORPHAN = new TreeLinkNode(0);
    
    TreeLinkNode sib(TreeLinkNode me, TreeLinkNode parent){
        
        if(parent == null) return null;
        
        if(parent.left != null && parent.left != me){
            return parent.left;
        }
        
        if(parent.right != null){
            return parent.right;
        }
        
        return sib(ORPHAN, parent.next);
        
    }
    
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null) return;
        
        if(root.left != null){
            root.left.next = sib(root.left, root);
        }
        
        
        if(root.right != null){
            root.right.next = sib(ORPHAN, root.next);
        }
        
        connect(root.right);
        connect(root.left);
        

    }
}