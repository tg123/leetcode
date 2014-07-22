public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(prices.length == 0 )return 0;
        
        int max = Integer.MIN_VALUE;
        int start = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[start] > prices[i]) start = i;
            int b = prices[i] - prices[start];
            if(b > max) max = b;
        }
        
        return max;
    }
}