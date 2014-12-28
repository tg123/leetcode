public class Solution {
    
    class XY{
        int x;
        int y;
        
        XY(int x, int y) { 
            this.x = x; 
            this.y = y;
        }
    }
    
    XY[] stack;
    
    int mx;
    int my;
    
    boolean search(char[][] board, char[] cs, final int index){
        
        if(index >= cs.length) return true;
        
        // final int mx = board.length, my = board[0].length;

        final int x = stack[index - 1].x, y = stack[index - 1].y;
        
        next:
        for(XY xy : new XY[]{new XY(x - 1, y), new XY(x + 1, y), new XY(x, y - 1), new XY(x, y + 1) }){
            int _x = xy.x;
            int _y = xy.y;
            
            for(int i = 0; i < index ; i++){
                if(stack[i].x == _x && stack[i].y == _y)
                    continue next;
            }
            
            if(_x >=0 && _x < mx && _y >= 0 && _y < my){
                if(board[_x][_y] == cs[index]){
                    stack[index] = new XY(_x , _y);
                    
                    if(search(board, cs, index + 1))
                        return true;
                }
            }
            
        }
        
        return false;
    }
    
    
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (board.length == 0) return false;
        
        
        int x = 0, y = 0;

        mx = board.length;
        my = board[0].length;
        
        char[] str = word.toCharArray();
        
        
        //if( str.length > mx * my ) return false; // fuck..
        
        stack = new XY[str.length];
        
        if(str.length == 0) return false;
        
        for(x = 0; x < mx; x++){
            for(y = 0; y < my; y++){
                if( board[x][y] == str[0] ){
                    
                    stack[0] = new XY(x, y);
                    if(search(board, str, 1))
                        return true;
                }
            }
        }
        
        return false;
    }
}