public class Solution {
    
    static class Bar{
        int pos;
        int height;
    }
    
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(A.length <= 2) return 0;
        
        Deque<Bar> stack = new LinkedList<Bar>();
        
        int water = 0;
        
        for(int i = 0; i < A.length ; i++){
            
            int bottom = 0;
            
            while(!stack.isEmpty()){
                Bar left = stack.pop();
                
                water += (i - left.pos - 1) * (Math.min(left.height, A[i]) - bottom);
                
                bottom = left.height;
                
                if(left.height > A[i]){
                    stack.push(left);
                    break;
                }
                    
            }
            
            
            
            Bar bar = new Bar();
            bar.pos = i;
            bar.height = A[i];
            
            stack.push(bar);
            
        }
        
        return water;
        
    }
}