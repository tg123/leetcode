public class Solution {
    

    
    public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length == 0) return false;
        
        
        int maxjump = 0;
        
        for(int i = 0; i < A.length; i++){
            if(i <= maxjump){
                if(i + A[i] < A.length - 1){
                    maxjump = Math.max(maxjump, i + A[i]);
                }else{
                    return true;
                }
            } else {
                return false;
            }
        }
        
        return false;
    }
}