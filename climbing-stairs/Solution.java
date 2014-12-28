public class Solution {
    public int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        
        int[] step = new int[Math.max(n + 1, 3)];
        
        
        step[0] = 0;
        step[1] = 1;
        step[2] = 2;
        
        for(int i = 3; i <= n; i++){
            step[i] = step[i - 1] + step[i - 2];
        }
        
        return step[n];
    }
}