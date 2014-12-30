public class Solution {
  public int trailingZeroes(int n) {

    int count = 0;

    int c2 = 0; // count of 2
    int c5 = 0; // count of 5

    for (int i = 1; i <= n; i++){
      int m = i;

      while(m % 5 == 0){
        m /= 5;
        c5++;
      }

      while(m % 2 == 0){
        m /= 2;
        c2++;
      }

      int c = Math.min(c2, c5);

      count += c;
      c2 -= c;
      c5 -= c;

    }

    return count;

  }
}
