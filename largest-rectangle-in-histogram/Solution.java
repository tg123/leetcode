public class Solution {
    
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