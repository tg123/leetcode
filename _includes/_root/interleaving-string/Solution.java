public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();
        char[] S3 = s3.toCharArray();
        
        if(S1.length + S2.length != S3.length) return false;
        
        int i;
        int j;
        
        boolean[][] map = new boolean[S1.length + 1][S2.length + 1];
        // i -> s1, j -> s2
        
        map[0][0] = true;
        
        for(i = 1; i <= S1.length; i++){
            map[i][0] = map[i - 1][0] && S1[i - 1] == S3[i - 1];
        }

        for(j = 1; j <= S2.length; j++){
            map[0][j] = map[0][j - 1] && S2[j - 1] == S3[j - 1];
        }
        
        for(i = 1; i <= S1.length; i++){
            for(j = 1; j <= S2.length; j++){
                
                if(map[i - 1][j]){
                    map[i][j] = S3[i + j - 1] == S1[i - 1];
                    continue;
                }
                
                if(map[i][j - 1]){
                    map[i][j] = S3[i + j - 1] == S2[j - 1];
                    continue;
                }
                
            }
        }
        
        return map[S1.length][S2.length];
        
    }
}