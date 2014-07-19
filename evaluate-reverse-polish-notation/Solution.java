public class Solution {
    
    
    public int evalRPN(String[] tokens) {
        
        
        final Deque stack = new LinkedList();
        
        for(String t : tokens){
            if("+".equals(t)){
                int v2 = (int) stack.pop();
                int v1 = (int) stack.pop();
                
                stack.push(v1 + v2);
            }else if("-".equals(t)){
                int v2 = (int) stack.pop();
                int v1 = (int) stack.pop();
                
                stack.push(v1 - v2);
            }else if("*".equals(t)){
                int v2 = (int) stack.pop();
                int v1 = (int) stack.pop();
                
                stack.push(v1 * v2);
            }else if("/".equals(t)){
                int v2 = (int) stack.pop();
                int v1 = (int) stack.pop();
                
                stack.push(v1 / v2);
            }else{
                stack.push(Integer.parseInt(t));
            }
        }
        
        return (int)stack.pop();
    }
}