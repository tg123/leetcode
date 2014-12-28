public class Solution {
    public int firstMissingPositive(int[] A) {
        
        final int N = A.length;
        
        next:
        for(int i = 0; i < N; i++){
            int v = A[i];
            
            if(v == i + 1) continue ;

            while(true){
                if(v <= 0 || v > N){
                    continue next;
                }
                
                int t = A[v - 1];
                
                if(t == v){
                    continue next;
                }
                
                A[v - 1] = v;
                v = t;
            }
            
        }
        
        for(int i = 0; i < N; i++){
            int v = A[i];
            
            if (v != i + 1){
                return i + 1;
            }
        }
        
        return N + 1;
        
    }
}