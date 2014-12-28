public class Solution {
    public void rotate(int[][] matrix) {
        
        
        final int mx = matrix.length; 
        final int my = matrix[0].length;
        int x,y;
        
        int t;
        
        int _my = my - 1;
        for(x = 0; x < mx - 1; x++){
            for(y = 0; y < _my; y++){
                int ny = mx - 1 - x;
                int nx = my - 1 - y;
                
                t = matrix[y][x];
                matrix[y][x] = matrix[ny][nx];
                matrix[ny][nx] = t;
                
            }
            _my--;
        }
        
        
        for(x = 0; x < mx ; x++){
            for(y = 0 ; y < my / 2; y++){
                int ny = my - 1 - y;
                int nx = x;
                
                t = matrix[y][x];
                matrix[y][x] = matrix[ny][nx];
                matrix[ny][nx] = t;
            }
        }
        
    }
}