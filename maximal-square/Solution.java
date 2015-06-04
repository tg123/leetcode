public class Solution {
    
    int maximalSquare(char[][] matrix, final int x, final int y){
        int l = 1;
        
        done:
        while(true){
        
            for(int i = 0; i <= l; i++){
                
                if(x + l >= matrix.length || y + l >= matrix[0].length){
                    break done;
                }
                
                
                if(matrix[x + l][y + i] != '1'){
                    break done;
                }
                
                if(matrix[x + i][y + l] != '1'){
                    break done;
                }
                
            }
            
            l++;
        }
        
        return l * l;
    }
    
    public int maximalSquare(char[][] matrix) {
        
        int max = 0;
        
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                if(matrix[x][y] == '1'){
                    max = Math.max(max, maximalSquare(matrix, x, y));
                }
            }
        }
        
        return max;
    }
}
