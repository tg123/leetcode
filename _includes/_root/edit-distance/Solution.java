public class Solution {
    public int minDistance(String word1, String word2) {
        
        // http://en.wikipedia.org/wiki/Levenshtein_distance
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        

        
        int[][] P = new int[w1.length + 1][w2.length + 1];
        
        int i, j;
        
        for(i = 1; i <= w1.length; i++){
            P[i][0] = i;
        }
        
        for(j = 1; j <= w2.length; j++){
            P[0][j] = j;
        }
        
        for(i = 1; i <= w1.length; i++){
            for(j = 1; j <= w2.length; j++){
                
                P[i][j] = Math.min(P[i - 1][j], P[i][j - 1]) + 1;
                
                if(w1[i - 1] == w2[j - 1]){
                    P[i][j] = Math.min(P[i - 1][j - 1], P[i][j]);
                }else {
                    P[i][j] = Math.min(P[i - 1][j - 1] + 1, P[i][j]);
                }
                
            }
        }
        
        return P[w1.length][w2.length];
    }
}