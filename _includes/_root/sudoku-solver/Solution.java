public class Solution {
    
    static final List<Character> VALID = Arrays.asList(new Character[]{ '1' , '2', '3', '4', '5', '6', '7', '8', '9'});
    
    boolean _solveSudoku(char[][] board){
        int mx = board.length;
        int my = board[0].length;

        int x ,y;

        for(x = 0; x < mx; x++){
            for(y = 0; y < my; y++){

                if(board[x][y] == '.'){
                    int _x, _y;
                    HashSet<Character> val = new HashSet<Character>(VALID);

                    for(_y = 0; _y < my; _y++)
                        val.remove(board[x][_y]);

                    for(_x = 0; _x < mx; _x++)
                        val.remove(board[_x][y]);

                    int sx = x / 3 * 3;
                    int sy = y / 3 * 3;

                    for(int offset = 0; offset < 9; offset++){
                        int ox = offset % 3;
                        int oy = offset / 3;

                        val.remove(board[sx + ox][sy + oy]);
                    }

                    for(char c : val){
                        board[x][y] = c;
                        
                        if(isValidSudoku(board)){
                            // try next '.'
                            if(_solveSudoku(board)){
                                return true;
                            }
                            
                            // try another number
                        }

                        board[x][y] = '.';
                    }
                    
                    // board[x][y] is '.' return false to fail fast
                    return false;
                }


            }
        }

        return true;
    }
    
    public void solveSudoku(char[][] board) {
        _solveSudoku(board);
    }
    
    boolean isValidSudoku(char[][] board) {

        int mx = board.length;
        int my = board[0].length;
        
        int x, y;
        
        for(x = 0; x < mx; x++){
            HashSet<Character> col = new HashSet<Character>();
            for(y = 0; y < my; y++){
                char c = board[x][y];
                if(c != '.'){
                    if(col.contains(c)) return false;
                    
                    col.add(c);
                } 
            }
        }
        
        for(y = 0; y < my; y++){
            HashSet<Character> row = new HashSet<Character>();
            for(x = 0; x < mx; x++){
                char c = board[x][y];
                if(c != '.'){
                    if(row.contains(c)) return false;
                    
                    row.add(c);
                } 
            }
        }
        
        for(x = 0; x < mx; x += 3){
            for(y = 0; y < my; y += 3){
                
                HashSet<Character> block = new HashSet<Character>();
                
                for(int offset = 0; offset < 9; offset++){
                    int ox = offset % 3;
                    int oy = offset / 3;
                    
                    char c = board[x + ox][y + oy];
                    if(c != '.'){
                        if(block.contains(c)) return false;
                    
                        block.add(c);
                    } 
                }
            }
        }
        
        return true;
    }    
    
}
