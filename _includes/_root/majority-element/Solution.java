public class Solution {
  public int majorityElement(int[] num) {
    int m = num[0];
    int c = 1;

    for(int i = 1; i < num.length; i++){
      if(num[i] == m){
        c++;
      }else if (c > 1){
        c--;
      }else{ // c == 1 && num[i] != m
        m = num[i];
      }
    }

    return m;
  }
}
