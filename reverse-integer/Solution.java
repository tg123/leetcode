public class Solution {
    public int reverse(int x) {
        
        if(x == Integer.MIN_VALUE) return 0;
        if(x < 0) return -reverse(-x);
        
        int y = 0;

         do {

            // y * 10 + x % 10 > Integer.MAX_VALUE
            if(y > (Integer.MAX_VALUE - x % 10) / 10){
                return 0;
            }
            
            y = y * 10 + x % 10;
            
            x /= 10;
            
        } while(x > 0);

        return y;
    }
}
