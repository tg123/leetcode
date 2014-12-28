public class Solution {
    public String strStr(String haystack, String needle) {
        
        if(haystack == null) return null;
        if(needle == null) return null;
        
        char[] _haystack = haystack.toCharArray();
        char[] _needle   = needle.toCharArray();
        
        if(_needle.length == 0) return haystack;
        if(_haystack.length < _needle.length) return null;
        
        
        int[] P = new int[_needle.length];

        for(int j = 2; j < _needle.length; j++){

            int k = 0;

            if(_needle[0 + P[j - 1]] == _needle[j - 1]){
                k = P[j - 1] + 1;
            }

            P[j] = k;
        }
        
        next:
        for(int i = 0; i < _haystack.length; /*void*/){
            
            for(int j = 0; j < _needle.length; j++){
                
                if(i + j >= _haystack.length) return null;
                
                if(_haystack[i + j] != _needle[j]){
                    i += Math.max(1, j - P[j]);
                    continue next;
                }
            }

            return new String(_haystack, i, _haystack.length - i);
        }
        
        return null;
    }
}