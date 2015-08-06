public class Solution {

    static final char[][] GOOD_PATTERNS = {
        {'9', '6'},
        {'6', '9'},
        {'1', '1'},
        {'8', '8'},
        {'0', '0'},
    };

    boolean isStrobogrammatic(char l, char r){
        char[] s = new char[]{l, r};

        for(char[] g : GOOD_PATTERNS){
            if(Arrays.equals(g, s)){
                return true;
            }
        }
        return false;
    }

    public boolean isStrobogrammatic(String num) {
        char[] S = num.toCharArray();

        for(int i = 0; i <= S.length / 2; i++){
            if(!isStrobogrammatic(S[i], S[S.length - 1 - i])){
                return false;
            }
        }

        return true;
    }
}
