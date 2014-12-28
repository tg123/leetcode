public class Solution {

    int safe(int[] X, int i){

        if ( i < 0) return Integer.MIN_VALUE;

        if ( i >= X.length) return Integer.MAX_VALUE;

        return X[i];
    }    
    
    int kth(int[] A, int[] B, int k){

        if (A.length == 0)
            return B[k];
            
        if (B.length == 0)
            return A[k];

        if (k == 0)
            return Math.min(A[0], B[0]);

        if (A.length == 1 && B.length == 1){
            // k must be 1
            return Math.max(A[0], B[0]);
        }

        int s = 0;
        int e = A.length;

        while ( s < e ){

            int m = (s + e) / 2;

            int n = k - m;

            if ( A[m] <= safe(B, n) ) {
                if (n == 0 || A[m] >= safe(B, n - 1)) {
                    return A[m];
                }
            }

            if ( safe(B, n) <= A[m] ){
                if (m == 0 || safe(B, n) >= A[m - 1]) {
                    return B[n];
                }
            }

            if ( A[m] < safe(B, n) ) {
                s = m + 1;
            } else {
                e = m;
            }

        }

        if (A[A.length - 1] < B[0]){
            return B[k - A.length];
        } else {
            return kth(B, A, k);
        }

    }
    
    
    public double findMedianSortedArrays(int A[], int B[]) {
        // median of {3, 3, 5, 9, 11} is 5
        // the median of {3, 5, 7, 9} is (5 + 7) / 2 = 6 wikipedia
        
        int s = A.length + B.length;
        final int k = s / 2;
        
        if(s % 2 == 1){
            return kth(A, B, k);
        }else{
            return (kth(A, B, k - 1) + kth(A, B, k)) / 2.0;
        }

    }
}