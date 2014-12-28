public class Solution {
    public int divide(int dividend, int divisor) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(dividend == 0) return 0;
        
        if(dividend == Integer.MIN_VALUE){
            if(divisor < 0)
                return 1 + divide(dividend - divisor, divisor);
            else
                return 0 - (1 + 0 - divide((dividend + divisor), divisor));
        }       
        
        if(divisor == Integer.MIN_VALUE){
            return dividend == divisor ? 1 : 0;
        }        
        
        if(dividend > 0 && divisor < 0) return 0 - divide(dividend, 0 - divisor);
        if(dividend < 0 && divisor > 0) return 0 - divide(0 - dividend, divisor);
        if(dividend < 0 && divisor < 0) return divide(0 - dividend, 0 - divisor);
        
        int quotient = 0;
        int a = 1;
        
        int r = divisor;
        
        while(dividend >= divisor ){
            
            if(r > dividend){
                a--;
                r -= divisor;
            }else{
                dividend -= r;
                quotient += a++;
                r += divisor;
            }
        }
        
        
        
        return quotient;
    }
}
