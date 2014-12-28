public class Solution {
    
    boolean[][] chessboard;
    
    int target;
    
    int rt;
    
    boolean tryput(final int row, final int col){
        for(int i = row - 1; i >= 0; i--){
            int offset = row - i;
            if(chessboard[i][col])
                return false;
            
            if(col - offset >= 0 && chessboard[i][col - offset])
                return false;
                
            if(col + offset <= target && chessboard[i][col + offset])
                return false;
        }
        
        return true;
    }
    
    void search(final int row){
        
        if( row > target){
            
            rt++;
            
            return;
        }
        
        for(int i = 0; i <= target ; i++){
            if(tryput(row, i)){
                
                chessboard[row][i] = true;    
            
                search(row + 1);
                
                chessboard[row][i] = false;  
            }
        }
        
    }
    
    public int totalNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        chessboard = new boolean[n][n];
        target = n - 1;
        
        rt = 0;
        
        search(0);
        
        return rt;
    }
}