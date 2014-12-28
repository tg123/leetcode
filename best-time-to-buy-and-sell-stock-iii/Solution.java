public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        
        int left_min = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            left_min = Math.min(left_min, prices[i]);
            left[i]  = Math.max(prices[i] - left_min, left[i - 1]);
        }
        
        int right_max = prices[prices.length - 1];
        
        for(int i = prices.length - 2; i >= 0; i--){
            right_max = Math.max(right_max, prices[i]);
            right[i]  = Math.max(right_max - prices[i], right[i + 1]);
        }
        
        int m = 0;
        
        for(int i = 0; i < prices.length; i++){
            m = Math.max(m, left[i] + right[i]);
        }
        
        return m;
        
    }
}
