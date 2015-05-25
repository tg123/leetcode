public class Solution {
    public String shortestPalindrome(String s) {
        char[] S = s.toCharArray();

        int[] P = new int[S.length];

        for(int i = S.length - 2; i >= 0; i--){
            if(S[i] == S[i + 1]){
                P[i] = P[i + 1] + 1;
            }
        }

        int i = 0;
        int e = S.length - 1;

        int j = e;

        while(i < j){

            if(S[i] == S[j]){

                i++;
                j--;

            } else {

                if(P[j] >= i){
                    j--;
                    e--;

                } else if(i > 0) {

                    i = 0;
                    e = j;

                } else {

                    j = e - 1;
                    e--;
                }
            }
        }

        StringBuilder sb = new StringBuilder(new String(S, e + 1, S.length - e - 1)).reverse();

        sb.append(s);

        return sb.toString();
    }
}
