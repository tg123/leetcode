public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        
        int pa = 0;
        int pb = 0;
        int up = 0;
        
        while(pa < m + pb && pb < n){
            
            int a = A[pa];
            int b = B[pb];
            
            if (a < b){
                pa++;
            }else{
                // shift up
                for(int i = pb + m; i > pa ; i--){
                    A[i] = A[i - 1];
                }
                
                A[pa] = b;
                pa++;
                pb++;
            }
            
        }
        
        for( ; pb < n; pb++){
            A[pb + m] = B[pb];
        }
        
    }
}