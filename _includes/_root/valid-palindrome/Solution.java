public class Solution {
    public boolean isPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null) return false;
        
        
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        while(i < j){
            while( (i < j) && !(('A' <= chars[i] && chars[i]<= 'Z') || ('a' <= chars[i] && chars[i]<= 'z') || ('0' <= chars[i] && chars[i]<= '9')  )  ) i++;
            
            while( (i < j) && !(('A' <= chars[j] && chars[j]<= 'Z') || ('a' <= chars[j] && chars[j]<= 'z') || ('0' <= chars[j] && chars[j]<= '9')  )  ) j--;
            
            if(chars[i] != chars[j]) return false;
            
            i++;
            j--;
            
            
        }
        
        return true;
        
    }
}