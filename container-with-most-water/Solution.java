public class Solution {
    public int maxArea(int[] height) {
        
        if(height.length <= 1) return 0;
        
        
        int st = 0;
        int ed = height.length - 1;
        
        
        int max = Integer.MIN_VALUE;
        
        while(st < ed){
            
            int current = Math.min(height[st] , height[ed]) * (ed - st);
            
            if(current > max) max = current;
            
            if(height[st] <= height[ed]){
                st++;
            }else{
                ed--;
            }
            
            
        }
        
        
        return max;
        
    }
}