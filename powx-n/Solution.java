public class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0) return 1;
        
        double s = myPow(x, n / 2);
        
        if(n % 2 == 0) return s * s;
        
        if(n > 0) return s * s * x;
        // else n < 0
        return s * s / x;
    }
}
