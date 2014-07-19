public class Solution {
    
    
    public boolean couple(char l, char r){
        return (l == '[' && r == ']') || (l == '(' && r == ')') || (l == '{' && r == '}');
    }
    
    public boolean isValid(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        
        if(s == null) return false;
        
        char[] chars = s.toCharArray();
        
        if(chars.length == 0 || chars.length % 2 == 1) return false;
        
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for(char c : chars){
            Character _peek = stack.peek();
            
            char peek = _peek != null ? _peek : ' ';
            //char c
            
            if(couple(peek, c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        return stack.size() == 0;
        
    }
}