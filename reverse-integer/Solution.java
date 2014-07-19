public class Solution {
    public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(x == 0) return 0;
        if(x < 0) return -reverse(-x);
        
        int len = (int)Math.log10(x) + 1;
        int[] y = new int[len];
        
        int i = 0;
        while(i < len){
            y[i] = x % 10;
            x /= 10;
            i++;
        }
        
        int s = 0;
        for(i = len - 1; i >=0 ; i--)
            s += y[i] * Math.pow(10, len - 1 - i);
        
        return s;
    }
}