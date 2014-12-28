public class Solution {
    public int search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int s = 0;
        int e = A.length;
        
        while(s < e){
            int mid = (s + e) /2;
            
            if(A[mid] == target){
                return mid;
            }
            
            if(target < A[mid]){
                // normal in first half
                
                if(A[s] <= A[mid] && A[s] <= target){
                    e = mid;
                // abnormal    
                }else if(A[mid] <= A[e - 1]){
                    e = mid;
                }else {
                    s = mid + 1;
                }
                
            } else {
   
                // normal in last half
                
                if(A[mid] <= A[e - 1] && target <= A[e - 1]){
                    s = mid + 1;
                } else if(A[s] <= A[mid]) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
   
            }
        }
        
        return -1;
    }
}