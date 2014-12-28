public class Solution {
    public int minCut(String s) {
        char[] S = s.toCharArray();
        
        if(S.length == 0) return 0;
        
        boolean[][] P = new boolean[S.length][S.length];
        
        // len 1
        Arrays.fill(P[1 - 1], true);
        
        // len 2
        for(int i = 0; i < S.length - 1; i++){
            P[2 - 1][i] = S[i] == S[i + 2 - 1];
        }
        
        // len 3 to max
        for(int len = 3; len <= S.length; len++){
            
            for(int i = 0; i < S.length - (len - 1); i++){
                P[len - 1][i] = P[len - 1 - 2][i + 1] && S[i] == S[i + len - 1];
            }
        }
        
        int[] mincut = new int[S.length + 1];
        
        mincut[0] = 0;
        mincut[1] = 0;
        
        for(int len = 2; len <= S.length; len++){
            
            if(P[len - 1][0]){
                mincut[len] = 0;
            }else{
                
                mincut[len] = mincut[len - 1] + 1;
                
                for(int i = 1; i < len - 1; i++){
                    
                    if(P[len - i - 1][i]){
                        mincut[len] = Math.min(mincut[i] + 1 , mincut[len]);
                    }
                }
            }
        }
        
        return mincut[S.length];
    }
}
