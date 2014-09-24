public class Solution {
    public int maxProduct(int[] A) {
        
        int max = A[0];
        int positive_history = A[0];
        int negative_history = A[0];

        for(int i = 1; i < A.length; i++){
            
            positive_history *= A[i];
            negative_history *= A[i];

            if(negative_history > positive_history){
                int t = negative_history;
                negative_history = positive_history;
                positive_history = t;
            }

            positive_history = Math.max(A[i], positive_history);
            negative_history = Math.min(A[i], negative_history);


            max = Math.max(max, positive_history);
        }
        
        return max;
    }
}
