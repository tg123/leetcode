public class Solution {
    
    void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
     
    public void sortColors(int[] A) {
        
        int red = 0;
        int blue = A.length - 1;
        
        int white = 0;
        
        while( white <= blue ){
            
            if(A[white] == 0){ // red 
                swap(A, white, red);
            
                red++;
                white++;
            }else if(A[white] == 1){ // white
                
                white++;
                
            }else if (A[white] == 2) { //blue
                
                swap(A, white, blue);
                
                blue--;
            }
        }
        
    }
}
