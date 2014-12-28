public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null) return 0;
        char[] str = s.toCharArray();
        if(str.length == 0) return 0;
        

        int max = 1;
        
        int barrier = 0;

        for(int i = 1; i < str.length; i++){
            for(int j = i - 1; j >= barrier;j--){
                if(str[i] == str[j]){
                    barrier = j + 1;
                    break;
                }
            }
            
            max = Math.max(max, i - barrier + 1);
        }
        
        
        return max;
        
    }
}