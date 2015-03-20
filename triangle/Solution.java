public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        final int size = triangle.size();
        if(size == 0) return 0;
        if(size == 1) return triangle.get(0).get(0);
        
        int[] s = new int[size];
        
        int i = 0;
        for(int v : triangle.get(size - 1)){
             s[i++] = v;
        }
        
        for(i = size - 2; i >=0 ; i--){
            List<Integer> step = triangle.get(i);
            
            // s[0] = min(s[0] + step[0], s[1] + step[0])
            
            for(int j = 0; j < step.size(); j++){
                s[j] = Math.min(step.get(j) + s[j], step.get(j) + s[j + 1]);
            }
            
        }

        return s[0];
    }
}
