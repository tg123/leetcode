public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        
        ArrayList<List<Integer>> rt = new ArrayList<List<Integer>>();
        
        if (num.length == 0){
            rt.add(new ArrayList<Integer>());
            
            return rt;
        }
        
        Arrays.sort(num);
        
        long mask = (long) Math.pow(2, num.length);
        
        next:
        for(long i = 0; i < mask; i++){
            
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            for(long j = 0; j < num.length; j++){
                
                long x = (long) Math.pow(2, j);
                
                if((x & i) == x){
                    level.add(num[(int)j]);
                }
            }
            
            next_lv:
            for(List<Integer> _level : rt){
                
                if(_level.size() == level.size()){
                    for(int li = 0; li < _level.size(); li++){
                        if(!_level.get(li).equals(level.get(li)))
                            continue next_lv;
                    }
                    
                    continue next;   
                }
            }
            rt.add(level);
            
        }
        
        return rt;
        
    }
}
