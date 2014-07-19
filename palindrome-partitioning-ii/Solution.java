public class Solution {

    public int minCut(String s) {
        final char[] S = s.toCharArray();
        final int N = S.length;
        
        if(N == 0) return 0;
        if(N == 1) return 0;
        if(N == 2) return S[0] == S[1] ? 0 : 1;
        
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
        
        
        int mincut[] = new int[N + 1]; // i -> end

        for(int i = N - 2; i >= 0; i--){

            if(P[i][N - 1]) {
                mincut[i] = 0;
            } else {
                mincut[i] = mincut[i + 1] + 1;

                for(int j = i + 1; j < N; j++){
                    if(P[i][j]){
                        mincut[i] = Math.min(1 + mincut[j + 1], mincut[i]);
                    }
                }
                //mincut = Math.min(minCut(s.substring(i + 1)) + 1, mincut);
            }
        }

        return mincut[0];
        
    }
}