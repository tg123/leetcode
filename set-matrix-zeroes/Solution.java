public class Solution {
    public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(matrix == null) return;
        int mx = matrix.length;
        if ( mx == 0) return;
        int my = matrix[0].length;
        
        int x, y;
        
        boolean xfz = false, yfz = false;
        
        for(x = 0; x < mx ; x++ ){
            if(matrix[x][0] == 0){
                xfz = true;
                break;
            }
        }
        
        for(y = 0; y < my ; y++ ){
            if(matrix[0][y] == 0){
                yfz = true;
                break;
            }
        }
        
        for(x = 1; x < mx ; x++){
            for(y = 1; y < my ; y++){
                if(matrix[x][y] == 0){
                    matrix[x][0] = 0;
                    matrix[0][y] = 0;
                }
            }
        }
        
        for(x = 1; x < mx ; x++ ){
            if(matrix[x][0] == 0){
                for(y = 0; y < my; y++){
                    matrix[x][y] = 0;
                }
            }
        }
        
        for(y = 1; y < my ; y++ ){
            if(matrix[0][y] == 0){
                for(x = 0; x < mx; x++){
                    matrix[x][y] = 0;
                }
            }
        }
        
        if(xfz){
            for(x = 0; x < mx ; x++ ){
                matrix[x][0] = 0;
            }
        }
        
        if(yfz){
            for(y = 0; y < my ; y++ ){
                matrix[0][y] = 0;
            }
        }        
    }
}