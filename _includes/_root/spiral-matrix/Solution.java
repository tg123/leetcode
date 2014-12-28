public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rt = new ArrayList<Integer>();
        
        if(matrix.length == 0) return rt;
        
        int x = 0, y = 0, my = matrix.length, mx = matrix[0].length;
        //int dx = 1, dy = 1;
        
        while(x < mx && y < my){
            for(int i = x; i < mx && y < my ; i++){
                rt.add(matrix[y][i]);
            }
            
            y++;
            
            for(int i = y; i< my && x < mx; i++){
                rt.add(matrix[i][mx - 1]);
            }
            
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
