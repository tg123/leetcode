public class Solution {
    
    static final char[][] CHAR_MAP = {
        {}, // 0
        {}, // 1
        { 'a', 'b', 'c'}, //2
        { 'd', 'e', 'f'}, //3
        { 'g', 'h', 'i'}, //4
        { 'j', 'k', 'l'}, //5
        { 'm', 'n', 'o'}, //6
        { 'p', 'q', 'r', 's'}, //7
        { 't', 'u', 'v'}, //8
        { 'w', 'x', 'y', 'z'}, //9
    };    

    ArrayList<String> rt;
    char[] stack;

    void find(char[] digits, int p){
        
        if(p == digits.length){
            rt.add(new String(stack));
        }else{
            
            int num = (int) (digits[p] - '0');
            
            for(char pc : CHAR_MAP[num]){
                stack[p] = pc;
                find(digits, p + 1);
            }
        }
    }    
    
    public List<String> letterCombinations(String digits) {
        
        rt = new ArrayList<>();
        stack = new char[digits.length()];
        
        find(digits.toCharArray(), 0);
        return rt;
    }
}
