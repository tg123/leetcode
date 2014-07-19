public class Solution {
    public int maxSubArray(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        //  max ( x + A[i] , x)
        
        int max = A[0];
        int x = A[0];
        
        for(int i = 1; i < A.length; i++){
            x = Math.max(A[i], x + A[i]);
            max = Math.max(max, x);
        }
        
        return max;
        
    }
}