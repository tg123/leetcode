public class Solution {
    public boolean search(int[] A, int target) {
        int s = 0;
        int e = A.length;
        
        while(s < e){
            int mid = (s + e) /2;
            
            if(A[mid] == target){
                return true;
            }
            
            if(target < A[mid]){
                // normal in first half
                if (A[s] == A[mid]) {
                    if(A[mid] == A[e - 1]){
                       // special
                       
                       s++;
                       e--;
                       
                    }else{
                       s = mid + 1; 
                    }
                    
                } else if(A[s] <= A[mid] && A[s] <= target){
                    e = mid;
                // abnormal    
                }else if(A[mid] <= A[e - 1]){
                    e = mid;
                }else {
                    s = mid + 1;
                }
                
            } else {
   
                // normal in last half
                if (A[mid] == A[e - 1]) {
                    if(A[s] == A[mid]){
                        s++;
                        e--; 
                    }else{
                       e = mid; 
                    }
                    
                    
                } else if(A[mid] <= A[e - 1] && target <= A[e - 1]){
                    s = mid + 1;
                } else if(A[s] <= A[mid]) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
   
            }
        }
        
        return false;
    }
}