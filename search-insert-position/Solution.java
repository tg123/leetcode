public class Solution {
    public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        for(int i = 0; i < A.length; i++){
            if(A[i] >= target) return i;
        }
        return A.length;
    }
}