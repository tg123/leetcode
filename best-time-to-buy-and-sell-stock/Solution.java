public class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        
        int lowest = Integer.MAX_VALUE;
        
        for(int p : prices){
    
            lowest = Math.min(lowest, p);
            
            max = Math.max(p - lowest, max);
        }
        
        return max;
    }
}
