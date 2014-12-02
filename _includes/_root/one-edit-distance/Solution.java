public class Solution {
  public boolean isOneEditDistance(String s, String t) {

    char[] S = s.toCharArray();
    char[] T = t.toCharArray();

    // make sure s is always to shorter one
    if (S.length > T.length) return isOneEditDistance(t, s);

    if (T.length - S.length > 1) return false;

    int diff = 0;

    int i = 0;
    int j = 0;

    for(/* void */; i < S.length; i++, j++){
      if(S[i] != T[j]){

        diff++;

        if(diff > 1) return false;

        // len(s) + 1 = len(t)
        if(S.length != T.length && S[i] == T[j + 1]){
          j++; // delete one from T
        }
      }
    }

    if (diff == 0){
      return j + 1 == T.length;
    }

    return j == T.length;
  }
}
