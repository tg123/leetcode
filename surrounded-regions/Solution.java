public class Solution {
    
    static class Point{
        int x;
        int y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    HashSet<String> boarderConnected;
    
    String pointId(int x, int y){
        return x + "," + y;
    }
    
    
    // fuck stack
    boolean connectIfNotConnected(char[][] board, int x, int y){
        
        if(x < 0 || y < 0) return false;
        if(x >= board.length || y >= board[0].length) return false;
        
        if(board[x][y] == 'X') return false;
        
        String id = pointId(x, y);
        if(boarderConnected.contains(id)) return false;
        
        boarderConnected.add(id);
        
        return true;
    }
    
    void connectBoarder(char[][] board, int x, int y){
        

        
        //connectBoarder(board, x + 1, y);
        //connectBoarder(board, x - 1, y);
        //connectBoarder(board, x, y + 1);
        //connectBoarder(board, x, y - 1);
        
        LinkedList<Point> queue = new LinkedList<Point>();
        
        queue.add(new Point(x, y));
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            if(connectIfNotConnected(board, p.x, p.y)){
            
                queue.add(new Point(p.x + 1, p.y));
                queue.add(new Point(p.x - 1, p.y));
                
                queue.add(new Point(p.x, p.y + 1));
                queue.add(new Point(p.x, p.y - 1));
            }
            
        }
        
    }
    
    public void solve(char[][] board) {

        int mx = board.length;
        if (mx < 3) return;
        
        int my = board[0].length;
        if (my < 3) return;
        
        boarderConnected = new HashSet<String>();
        
        int x;
        int y;
        
        for(x = 0; x < mx; x++){
            connectBoarder(board, x, 0);
            connectBoarder(board, x, my - 1);
        }
        
        for(y = 0; y < my; y++){
            connectBoarder(board, 0, y);
            connectBoarder(board, mx - 1, y);
        }
        
        for(x = 0; x < mx; x++){
            for(y = 0; y < my; y++){
                if(board[x][y] == 'O'){
                    if(!boarderConnected.contains(pointId(x, y))){
                        board[x][y] = 'X';
                    }
                }
            }
        }
        
        
        
    }
}