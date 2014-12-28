public class Solution {
    
    static class Bar{
        int pos;
        int height;
        
        Bar(int pos, int height){
            this.pos = pos;
            this.height = height;
        }
    }
    
    int containWater(Deque<Bar> queue){
        
        Bar left  = queue.peekFirst();
        Bar right = queue.peekLast();
        
        int water = 0;
        
        if(right.height >= left.height){
        
            water += Math.min(right.height, left.height) * (right.pos - left.pos - 1);
            
            queue.removeFirst(); // remove left
            
            // remove stones
            while(queue.size() > 1){
                water -= queue.removeFirst().height;
            }
        }
        
        return water;
    }
    
    int[] reverseAndToInt(Deque<Bar> queue){
        int[] a = new int[queue.size()];
        int i = 0;

        while(!queue.isEmpty()){
            a[i++] = queue.removeLast().height;

        }

        return a;
    }
    
    public int trap(int[] A) {
        
        if (A.length <= 2) return 0;
        
        Deque<Bar> queue = new LinkedList<Bar>();
        
        int s = 0;
        while(s < A.length && A[s] == 0) s++;
        
        if(s < A.length)
            queue.add(new Bar(s, A[s]));
        
        int water = 0;
        
        for(int i = s + 1; i < A.length; i++){
            
            queue.add(new Bar(i, A[i]));
            
            water += containWater(queue);
        }
        
        water += trap(reverseAndToInt(queue));
        
        return water;
    }
}
