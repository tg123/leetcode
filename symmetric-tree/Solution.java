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
    
    static final Object EMPTY = new Object();
    
    TreeNode _root;
    
    Deque stack;
    
    boolean lefthalf = true;
    
    boolean sym = true;
    
    void inorder(TreeNode root, TreeNode bro){
        
        if(root == null){
            
            if(bro != null){
                if(lefthalf){ // left half
                
                    stack.push(EMPTY);
                    
                }else{ // right half
                
                    if(stack.isEmpty() || stack.pop() != EMPTY) sym = false;
                }
            }
            
            
            return;
            
        }
        
        inorder(root.left, root.right);
        
        //visit
        if(root == _root){
            lefthalf = false;
            
        }else if(lefthalf){ // left half
        
            stack.push(root.val);
            
        }else{ // right half
            
            if(stack.isEmpty() || stack.pop() != root.val) sym = false;
        }
        
        inorder(root.right, root.left);
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        _root = root;
        stack = new LinkedList();
        lefthalf = true;
        sym = true;
        
        inorder(root, null);
        
        return sym && stack.isEmpty();
    }
}