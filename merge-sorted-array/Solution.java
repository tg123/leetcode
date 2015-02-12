public class Solution {
    
    int safe(int X[], int i){
        if(i < 0) return Integer.MIN_VALUE;
        
        return X[i]; 
    }
    
    public void merge(int A[], int m, int B[], int n) {
        
        int t = A.length - 1;
        
        int pa = m - 1;
        int pb = n - 1;
        
        while(t >= 0){
            
            int a = safe(A, pa);
            int b = safe(B, pb);
            
            if(a > b){
                A[t] = a;
                pa--;
            }else{
                A[t] = b;
                pb--;
            }
            
            t--;
        }
        
    }
}
