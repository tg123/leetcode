public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        ArrayList<List<Integer>> rt = new ArrayList<List<Integer>>();
        
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
