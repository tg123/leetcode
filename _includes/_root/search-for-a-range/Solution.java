public class Solution {
    public int[] searchRange(int[] A, int target) {
        
        int s = 0, e = A.length;
        
        while( s < e ){
            int mid = (s + e) / 2;
            
            if(A[mid] == target){
                
                int _s = mid, _e = mid;
                
                while(_s - 1 >= 0       && A[_s - 1] == target) _s--;
                while(_e + 1 < A.length && A[_e + 1] == target) _e++;
                
                return new int[]{_s, _e};
                
            }else if(A[mid] < target){
                s = mid + 1;
            }else if(A[mid] > target){
                e = mid;
            }
            
        }
        
        return new int[]{-1, -1};
        
    }
}