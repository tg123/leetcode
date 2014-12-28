public class Solution {
    public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n == 0) return 1;
        
        double s = pow(x, n /2);
        
        if(n % 2 == 0)
        return s * s;
        else if(n > 0)
        return s * s * x;
        else 
        return s * s / x;
        
        
    }
}
