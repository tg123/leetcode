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
    
    static final int STACK_SIZE = 10;
    
    int sum;
    
    int[] stack;

    ArrayList<ArrayList<Integer>> collect;
    
    void findsum(TreeNode root, int current, int ps){
        
        if(root == null) return;
        
        if(current + root.val == sum && root.left == null && root.right == null){
            
            ArrayList<Integer> rt = new ArrayList<Integer>();
            
            for(int i = 0; i < ps; i++){
                rt.add(stack[i]);
            }
            
            rt.add(root.val);
            
            collect.add(rt);
            
        }else{
            
            if(ps >= stack.length)
                stack = Arrays.copyOf(stack, stack.length + STACK_SIZE);
            
            stack[ps] = root.val;
            
            findsum(root.left, current + root.val, ps + 1);
            findsum(root.right, current + root.val, ps + 1);
            
        }
        
        
        
    }
    
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        this.sum = sum;
        
        stack = new int[STACK_SIZE];
        collect = new ArrayList<ArrayList<Integer>>();
        
        findsum(root, 0, 0);
        
        return collect;
    }
}