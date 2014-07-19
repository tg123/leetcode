public class Solution {
    
    static final char[][] CHAR_MAP = {
        null, // 0
        null, // 1
        new char[] { 'a', 'b', 'c'}, //2
        new char[] { 'd', 'e', 'f'}, //3
        new char[] { 'g', 'h', 'i'}, //4
        new char[] { 'j', 'k', 'l'}, //5
        new char[] { 'm', 'n', 'o'}, //6
        new char[] { 'p', 'q', 'r', 's'}, //7
        new char[] { 't', 'u', 'v'}, //8
        new char[] { 'w', 'x', 'y', 'z'}, //9
    };
    
    ArrayList<String> rt;
    char[] stack;
    
    void find(char[] digits, int p){
        
        if(p == digits.length){
            rt.add(new String(stack));
        }else{
            
            int num = (int) (digits[p] - '0');
            
            if(CHAR_MAP[num] != null)
                for(char pc : CHAR_MAP[num]){
                    stack[p] = pc;
                    find(digits, p + 1);
                }
        }
        
    }
    
    public ArrayList<String> letterCombinations(String digits) {
        
        rt = new ArrayList<String>();
        stack = new char[digits.length()];
        
        find(digits.toCharArray(), 0);
        
        return rt;
    }
}