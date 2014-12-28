public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        char[] S = s.toCharArray();
        
        boolean[] P = new boolean[S.length + 1];
        P[0] = true;
        
        for(int i = 0; i < S.length; i++){
            
            for(int j = 0; j <= i; j++){
                if(P[j] && dict.contains(new String(S, j, i - j + 1))){
                    P[i + 1] = true;
                    continue;
                }
            }
        }
        
        return P[S.length];
        
        
    }
}