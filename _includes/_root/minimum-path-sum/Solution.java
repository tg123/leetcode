public class Solution {
    public int minPathSum(int[][] grid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        
        
        int mx = grid.length;
        if(mx == 0) return 0;
        
        int my = grid[0].length;
        
        for(int x = 1; x < mx ; x++){
            grid[x][0] += grid[x - 1][0];
        }
        
        for(int y = 1; y < my ; y++){
            grid[0][y] += grid[0][y - 1];
        }
        
        for(int x = 1; x < mx; x++){
            for(int y = 1; y < my; y++){
                grid[x][y] += Math.min(grid[x - 1][y], grid[x][y - 1]);
            }
        }
        
        return grid[mx - 1][my - 1];
    }
}