public class Solution {
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(m == 0 || n == 0) return 0;
        
        int[][] matrix = new int[m][n];
        
        int x, y;
        
        for(x = 0; x < m; x++)
            matrix[x][0] = 1;
        
        for(y = 0; y < n; y++)
            matrix[0][y] = 1;
            
        
        for(x = 1; x < m; x++){
            for(y = 1; y < n; y++){
                matrix[x][y] = matrix[x - 1][y] + matrix[x][y - 1];
            }
        }
        
        return matrix[m - 1][n - 1];
    }
}