public class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        
        if ( t.length == 0) return "";
        if ( t.length > s.length ) return "";
        
        
        int mstart = 0;
        int mend = -1;
        
        int gstart = 0;
        int gend = 0;
        
        int[] need = new int[256];
        int[] seen = new int[256];
        
        int checksum = 0;
        
        for(char c : t){
            need[(int)c]++;
        }

        for(/*void*/; gend < s.length; gend++ ){
            
            int i = (int)s[gend];
            if(need[i] > 0){
                seen[i]++;
                
                if(seen[i] <= need[i])
                    checksum++;
            }
            
            
            if(checksum == t.length){
                
                if(mend < 0) mend =  s.length - 1;
                
                for(/*void*/; gstart <= gend; gstart++){
                    
                    i = (int)s[gstart];
                    if(need[i] > 0){
                        if( seen[i] > need[i] ){
                            seen[i]--;
                        } else {
                            break;
                        }
                    }
                }
                
                if(gend - gstart < mend - mstart ){
                    mstart = gstart;
                    mend = gend;
                }
                
            }
            
        }


        return S.substring(mstart, mend + 1);
    }
}