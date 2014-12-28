public class Solution {
    public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A.length == 0) return 0;
        
        int len = 0;
        
        for(int i = 0; i< A.length; i++){
            if(A[i] != elem) A[len++] = A[i];
        }


        return len;
    }
}