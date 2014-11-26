public class Solution {

  static class Context {
    int start = 0;
    int end   = 0;

    Map<Character, Integer> counts = new HashMap<Character, Integer>();

    int len(){
      return end - start + 1;
    }

    void add(Character c) {
      Integer i = counts.get(c);
      if(i == null){
        i = 0;
      }

      i++;

      counts.put(c, i);
    }

    void remove(Character c){
      Integer i = counts.remove(c);
      if(i == null){
        return;
      }

      i--;

      if(i > 0){
        counts.put(c, i);
      }
    }
  }

  public int lengthOfLongestSubstringTwoDistinct(String s) {

    char[] S = s.toCharArray();

    if(S.length == 0) return 0;

    int max = 1;

    Context context = new Context();

    for(int i = 0; i < S.length; i++){
      Character c = S[i];

      context.add(c);
      context.end = i;

      // need trim to 2

      for(int j = context.start; context.counts.size() > 2 ;j++) {
        Character _c = S[j];
        context.remove(_c);
        context.start = j + 1;
      }

      max = Math.max(context.len(), max);
    }


    return max;
  }
}
