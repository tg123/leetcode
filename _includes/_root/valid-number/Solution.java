public class Solution {
    
    
    public boolean isNumber(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if ( s == null) return false;
        else if( s.length() == 0 ) return false;
        
        char[] chars = s.toCharArray();
        int st = 0 , ed = chars.length - 1;
        
        while((st < ed ) && chars[st] == ' ') st++;
        while((st < ed ) && chars[ed] == ' ') ed--;
        
        if(chars[st] == ' ') return false;
        
        boolean dot = false;
        boolean ex = false;
        boolean num = false;
        
        for(int i = st; i <= ed; i++ ){
            char c = chars[i];
            if ('0' <= c && c <= '9'){
                num = true;
            }else if ( c == 'e'){
                if(ex) return false;
                if(!num) return false;
                ex = true;
                num = false;
                dot = false;
            }else if ( c == '.'){
                if(dot) return false;
                if(ex) return false;
                dot = true;
            }else if ( c == '-' || c == '+' ){
                if(num || dot)return false;
            }else
                return false;
        }
        
        return num;
        
    }
}