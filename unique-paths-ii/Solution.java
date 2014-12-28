public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int mx = obstacleGrid.length;
        int my = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid[mx - 1][my - 1] == 1) return 0;
        
        int x, y;
        
        boolean blocked = false;
        for(x = 1; x < mx ; x++){
            if (obstacleGrid[x][0] == 1) blocked = true;
            obstacleGrid[x][0] = blocked ? 0 : 1;
        }
        
        blocked = false;
        for(y = 1; y < my ; y++){
            if (obstacleGrid[0][y] == 1) blocked = true;
            obstacleGrid[0][y] = blocked ? 0 : 1;
        }        
        
        
        obstacleGrid[0][0] = 1;
        
        
        for(x = 1; x < mx ; x++){
            for(y = 1; y < my; y++){
                if(obstacleGrid[x][y] == 1) 
                    obstacleGrid[x][y] = 0;
                else
                    obstacleGrid[x][y] = obstacleGrid[x - 1][y] + obstacleGrid[x][y - 1];
            }
        }
        
        return obstacleGrid[mx - 1][my - 1];
        
    }
}