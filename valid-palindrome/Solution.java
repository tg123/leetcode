public class Solution {
    
    boolean valid(char[] chars, int i){
        return !(('A' <= chars[i] && chars[i]<= 'Z') 
                || ('a' <= chars[i] && chars[i]<= 'z') 
                || ('0' <= chars[i] && chars[i]<= '9'));
    }
    
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        
        while(i < j){
            
            // ignore space etc.
            while( (i < j) && valid(chars, i)) i++;
            while( (i < j) && valid(chars, j)) j--;
            
            if(chars[i] != chars[j]) return false;
            
            i++;
            j--;
        }
        
        return true;
    }
}
