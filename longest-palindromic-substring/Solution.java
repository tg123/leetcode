public class Solution {
    public String longestPalindrome(String s) {
        
        char[] S = s.toCharArray();
        
        if(S.length == 0) return "";
        
        boolean[][] P = new boolean[S.length][S.length];
        
        int maxi = 0;
        int maxlen = 1;
        
        // len 1
        Arrays.fill(P[1 - 1], true);
        
        // len 2
        for(int i = 0; i < S.length - 1; i++){
            if(S[i] == S[i + 2 - 1]){
                P[2 - 1][i] = true;
                maxi = i;
                maxlen = 2;
            }
        }
        
        // len 3 to max
        for(int len = 3; len <= S.length; len++){
            
            for(int i = 0; i < S.length - (len - 1); i++){
                
                if(P[len - 1 - 2][i + 1] && S[i] == S[i + len - 1]){
                    P[len - 1][i] = true;
                    maxi = i;
                    maxlen = len;
                }
            }
        }
        
        return s.substring(maxi, maxi + maxlen);
    }
}
