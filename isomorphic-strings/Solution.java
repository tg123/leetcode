public class Solution {

    boolean isIsomorphic(char[] S, char[] T) {
        char[] MAP = new char[256];

        for(int i = 0; i < S.length; i++) {

            if(MAP[(int)S[i]] == 0) {
                // not mapped
                MAP[(int)S[i]] = T[i];
            } else {

                if ( MAP[(int)S[i]] != T[i]) {
                    return false;
                }
            }

        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        if(S.length != T.length) return false;

        return isIsomorphic(S, T) && isIsomorphic(T, S);

    }
}
