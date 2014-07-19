public class Solution {
    public int sqrt(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(x < 0) return -1;
        if(x == 0) return 0;

        // x/t + t = 2t
        double t = (double)x;
        double tt = 0;
        while( (int)tt - (int)t != 0 ){
            tt = t;
            t = (x/t + t) /2;
            
        }
        
        return (int)tt;
    }
}