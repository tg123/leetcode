public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(prices.length <= 1) return 0;
        
        int profit = 0;
        
        int hold = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            
            
            if(hold < prices[i]){
                profit += prices[i] - hold; // sell
                
            }
            
            hold = prices[i];
        }
        
        return profit;
    }
}