public class Solution {

  void swap(char[] s, int i, int j){
    char t = s[i];
    s[i]   = s[j];
    s[j]   = t;
  }

  void reverse(char[] s, int st, int ed){
    int l = ed - st;

    for(int i = st; i < st + l / 2; i++){
      swap(s, i, ed + st - i - 1);
    }
  }

  public void reverseWords(char[] s) {
    reverse(s, 0, s.length);

    int nextWordStart = 0;
    for(int i = 0; i < s.length; i++){
      if(s[i] == ' '){
        reverse(s, nextWordStart, i);
        nextWordStart = i + 1;
      }
    }

    reverse(s, nextWordStart, s.length);
  }
}
