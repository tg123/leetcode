public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int p = 0;
        
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        
        here:
        
        while(true){
            
            if( p >= strs[0].length() ) break;
            
            char c = strs[0].charAt(p);
            
            for(String str : strs){
                if(str.length() <= p || str.charAt(p) != c) break here;
            }
            
            p++;
            
        }
        
        return strs[0].substring(0, p);
        
        
        
    }
}