public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        
        char[] chars = s.toCharArray();
        if(chars.length <= 1) return 0;
        
        LinkedList<Character> stack = new LinkedList<Character>();
        
        int[] count = new int[chars.length];
        int max = 0;
        
        for(int i = 0 ; i<chars.length; i++ ){
            
            Character ins = stack.peek();
            Character cur = chars[i];
             
            if(ins != null && ins == '(' && cur == ')'){
                stack.pop();
                
                count[stack.size()] += 2 + count[stack.size() + 1];
                count[stack.size() + 1] = 0;
                
                max = Math.max(max, count[stack.size()]);
                
            }else{
                stack.push(cur);  
            }
        }
        
        return max;
    }
}
