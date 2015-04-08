public class Solution {

    boolean allowed(int x, int y, final int mx, final int my, char[][] grid, boolean[][] visited){
        return (x < mx) && (x >= 0)
            && (y < my) && (y >= 0)
            && (grid[x][y] == '1')
            && (!visited[x][y]);
    }

    void travel(int x, int y, final int mx, final int my, char[][] grid, boolean[][] visited){

        // x - 1, y
        // x + 1, y
        // x, y - 1
        // x, y + 1

        visited[x][y] = true;

        for(int[] xy: new int[][]{ {x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1} }){

            int _x = xy[0];
            int _y = xy[1];

            if(allowed(_x, _y, mx, my, grid, visited)){
                travel(_x, _y, mx, my, grid, visited);
            }
        }

    }

    public int numIslands(char[][] grid) {

        final int mx = grid.length;
        if(mx == 0) return 0;
        final int my = grid[0].length;

        int count = 0;
        boolean[][] visited = new boolean[mx][my];

        for(int x = 0; x < mx; x++){
            for(int y = 0; y < my; y++){
                if(allowed(x, y, mx, my, grid, visited)){

                    travel(x, y, mx, my, grid, visited);

                    count++;
                }
            }
        }

        return count;
    }
}
