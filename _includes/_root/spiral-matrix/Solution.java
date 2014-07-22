public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<Integer> rt = new ArrayList<Integer>();
        
        if(matrix.length == 0) return rt;
        
        int x = 0, y = 0, my = matrix.length, mx = matrix[0].length;
        //int dx = 1, dy = 1;
        
        
        
        while(x < mx && y < my){
            for(int i = x; i < mx && y < my ; i++){
                rt.add(matrix[y][i]);
            }
            
            //dx *= -1;
            y++;
            
            for(int i = y; i< my && x < mx; i++){
                rt.add(matrix[i][mx - 1]);
            }
            
            //dy *= -1;
            mx--;
            
            for(int i = mx - 1; i >= x && y < my ; i--){
                rt.add(matrix[my - 1][i]);
            }
            
            my--;
            
            for(int i = my - 1; i >= y && x < mx; i--){
                rt.add(matrix[i][x]);
            }
            
            x++;
                
        }
        
        
        return rt;
    }
}