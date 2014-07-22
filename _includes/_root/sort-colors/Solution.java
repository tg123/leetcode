public class Solution {
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int red  = 0;
        int blue = A.length - 1;
        
        int p = 0;
        
        int t = 0;
        
        while(p <= blue){
            
            if(A[p] == 0){ //red
                t = A[p];
                A[p] = A[red];
                A[red] = t;
                
                red++;
                p++;
                
            }else if(A[p] == 2){ // blue
                t = A[p];
                A[p] = A[blue];
                A[blue] = t;
                
                blue--;
            }else{ // white
            
                p++;
                
            }
            
        }
    }
}