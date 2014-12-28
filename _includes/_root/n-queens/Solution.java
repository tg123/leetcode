public class Solution {
    boolean[][] chessboard;
    
    int target;
    
    ArrayList<String[]> rt;
    
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
            
            String[] valid = new String[target + 1];
            
            for(int i = 0; i <= target ; i++){
                char[] s = new char[target + 1];
                for(int j = 0; j <= target; j++){
                    s[j] = chessboard[i][j] ? 'Q' : '.';
                }
                
                valid[i] = new String(s);
            }
            
            rt.add(valid);
            
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
    
    public List<String[]> solveNQueens(int n) {
        chessboard = new boolean[n][n];
        target = n - 1;
        
        rt = new ArrayList<String[]>();
        
        search(0);
        
        return rt;
    }
}
