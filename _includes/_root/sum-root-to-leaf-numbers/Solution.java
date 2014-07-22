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
    
    int[] stack;
    int sum = 0;
    
    static final int SIZE = 10;
    
    void findleaf(TreeNode root, int pstack){
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){

            final int size = pstack;
            
            sum += root.val;
            
            for(int i = 0; i < size; i++){
                sum += stack[i] * Math.pow(10, size - i);
            }
            
            
        }else{
            
            if(pstack >= stack.length)
                stack = Arrays.copyOf(stack, stack.length + SIZE);
                
            stack[pstack] = root.val;
            
            findleaf(root.left, pstack + 1);
            findleaf(root.right, pstack + 1);
            
        }
        
    }
    
    public int sumNumbers(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        stack = new int[SIZE];
        sum = 0;
        
        findleaf(root, 0);
        
        return sum;
    }
}