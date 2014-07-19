public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<ArrayList<Integer>> rt = new ArrayList<ArrayList<Integer>>();
        
        if (S.length == 0){
            rt.add(new ArrayList<Integer>());
            
            return rt;
        }
        
        Arrays.sort(S);
        
        long mask = (long) Math.pow(2, S.length);
        
        for(long i = 0; i < mask; i++){
            
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            for(long j = 0; j < S.length; j++){
                
                long x = (long) Math.pow(2, j);
                
                if((x & i) == x){
                    level.add(S[(int)j]);
                }
            }
            
            rt.add(level);
            
        }
        
        return rt;
        
    }
}