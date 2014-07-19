public class Solution {
    public String longestPalindrome(String s) {
        
        
        // http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
        
        final char[] S = s.toCharArray();
        final int N = S.length;
        
        if(N == 0) return "";
        if(N == 1) return s;
        if(N == 2) return S[0] == S[1] ? s : "";
        
        boolean[][] P = new boolean[N][N];
        
        for(int i = 0; i < N - 1; i++){
            P[i][i] = true;
            P[i][i + 1] = S[i] == S[i + 1];
        }
        
        P[N - 1][N - 1] = true;
        
        for(int j = 2; j < N; j++){
            for(int i = 0; i < j; i++){
                P[i][j] |= P[i + 1][j - 1] && S[i] == S[j];
            }
        }
        
        int mi = 0;
        int mj = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(P[i][j] && (j - i > mj - mi)){
                    mi = i;
                    mj = j;
                }
            }
        }        
        
        return new String(S, mi, mj - mi + 1);
    }
}