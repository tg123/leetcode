public class Solution {
    public boolean isMatch(String s, String p) {
        
        
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        
        int checkpointS = -1;
        int checkpointP = -1;
        
        int j = 0;
        
        for(int i = 0; i < S.length; /*void*/){
            
            if(j < P.length) {

                if(S[i] == P[j] || P[j] == '?'){
                    i++;
                    j++;
                    continue;
                }   
                
                if(P[j] == '*'){
                    
                    checkpointS = i;
                    checkpointP = j;
                    
                    j++;
                    continue;
                }
            }
            
            // mismatch
            
            if(checkpointS >= 0){
                
                checkpointS++;
                
                // restore
                i = checkpointS;
                j = checkpointP + 1;
                continue;
            }
            
            return false;
        }
        
        while(j < P.length) {
            if(P[j] == '*'){
                j++;
            } else {
                return false;
            }
        }
        
        return true;
    }
}