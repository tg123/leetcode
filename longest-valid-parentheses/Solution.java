public class Solution {
    public int longestValidParentheses(String ss) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(ss == null) return 0;
        
        char[] chars = ss.toCharArray();
        if(chars.length <= 1) return 0;
        
        LinkedList<Character> s = new LinkedList<Character>();
        
        int[] max = new int[chars.length];
        int len = 0;
        for(int i = 0 ; i<chars.length; i++ ){
            
            Character _ins = s.peek();
            char ins = _ins != null ? _ins : ' ';
            char cur = chars[i];
             
            if(ins == '(' && cur == ')'){
                s.pop();
                max[s.size()] += 2 + max[s.size() + 1];
                max[s.size() + 1] = 0;
            }else{
              s.push(cur);  
            }
        }
        
        int _max = 0;
        for(int i = 0; i<max.length; i++)
            if(max[i] > _max) _max = max[i];
        
        return _max;
    }
}