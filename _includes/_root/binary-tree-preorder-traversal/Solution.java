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
    
    static enum ReturnAddress {
        PRE, IN, POST, DONE;
    }
    
    static class StackState {
        ReturnAddress returnAddress = ReturnAddress.PRE;
        TreeNode param;
        
        StackState(TreeNode param){
            this.param = param;
        }
    }
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> rt = new ArrayList<Integer>();

        Deque<StackState> stack = new LinkedList<StackState>();
        
        if(root != null)
            stack.push(new StackState(root));
        
        while(!stack.isEmpty()){
            
            StackState current = stack.pop();
            
            switch(current.returnAddress){
                case PRE:
                    current.returnAddress = ReturnAddress.IN;
                    rt.add(current.param.val);
                    
                case IN:
                    current.returnAddress = ReturnAddress.POST;
                    
                    if(current.param.left != null){
                        stack.push(current);
                        stack.push(new StackState(current.param.left));
                        continue;
                    }
                case POST:
                    current.returnAddress = ReturnAddress.DONE;
                
                    if(current.param.right != null){
                        stack.push(current);
                        stack.push(new StackState(current.param.right));
                        continue;
                    }                
                default:
                    break;
            }
        }
        
        
        return rt;
        
    }
}
