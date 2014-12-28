public class Solution {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[][] rt = new int[n][n];
        if(n <= 0) return rt;
        
        int c = 1;
        
        int x = 0, y = 0, my = n , mx = n;
        
        while(x < mx && y < my){
            for(int i = x; i < mx && y < my; i++){
                rt[y][i] = c++;
            }
            
            y++;
            
            for(int i = y; i < my && x < mx ; i++ ){
                rt[i][mx - 1] = c++;
            }
            
            mx--;
            
            for(int i = mx - 1; i >= x && y < my; i--){
                rt[my - 1][i] = c++;
            }
            
            my--;
            
            for(int i = my - 1; i>= y && x < mx; i--){
                rt[i][x] = c++;
            }
            
            x++;
            
        }
        
        return rt;
        
        
    }
}