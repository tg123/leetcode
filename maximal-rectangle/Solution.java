public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int x;
        int y;

        int mx = matrix.length;
        if(mx == 0) return 0;
        int my = matrix[0].length;
        if(my == 0) return 0;


        int[][] _matrix = new int[mx][my];

        for(x = 0; x < mx; x++){
            for(y = 0; y < my; y++) {
                _matrix[x][y] = matrix[x][y] == '1' ? 1 : 0;
            }
        }


        int max = 0;

        for (x = 0; x < mx; x++){
            for(y = my - 1; y > 0; y--){
                if(matrix[x][y - 1] != '0' && matrix[x][y] != '0'){
                    _matrix[x][y - 1] += _matrix[x][y];
                }
            }
        }

        for(y = 0; y < my; y++){

            int h[] = new int[mx];

            for(x = 0; x < mx; x++)
                h[x] = _matrix[x][y];

            max = Math.max(max, largestRectangleArea(h));
        }

        _matrix = new int[mx][my];


        for(x = 0; x < mx; x++){
            for(y = 0; y < my; y++) {
                _matrix[x][y] = matrix[x][y] == '1' ? 1 : 0;
            }
        }

        for (y = 0; y < my; y++){
            for(x = mx - 1; x > 0; x--){
                if(matrix[x - 1][y] != '0' && matrix[x][y] != '0'){
                    _matrix[x - 1][y] += _matrix[x][y];
                }
            }
        }

        for(x = 0; x < mx; x++){
            max = Math.max(max, largestRectangleArea(_matrix[x]));
        }


        return max;
    }
    
    
    static class Rect {
        int width = 1;
        int height;
        
        Rect(int height){
            this.height = height;
        }
    }
    
    public int largestRectangleArea(int[] height) {
        
        if(height.length == 0) return 0;
        
        height = Arrays.copyOf(height, height.length + 1);
        height[height.length - 1] = 0;
        
        Deque<Rect> stack = new LinkedList<Rect>();
        
        stack.push(new Rect(height[0]));
        
        int max = 0;
        
        next:
        for(int i = 1; i < height.length; i++){
            int h = height[i];
            
            Rect r = new Rect(h);
            
            int sl = 0;
            while(true){
                
                if(stack.isEmpty() || h > stack.peek().height){
                    stack.push(r);
                    continue next;
                }
                
                
                Rect left = stack.pop();
                
                sl += left.width;
                max = Math.max(max, left.height * sl);
                
                r.width = 1 + sl ; // merge left into new
            }

        }
        
        return max;
    }
}