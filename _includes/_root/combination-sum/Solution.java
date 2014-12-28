public class Solution {
    int target;
    
    int[] candidates;
    
    int[] stack;
    
    ArrayList<List<Integer>> rt;
    
    void search(int sp, int cur){

        if(cur == target){
            ArrayList<Integer> found = new ArrayList<Integer>();
            for(int i = 0; i < stack.length; i++){
                for(int j = 0; j < stack[i]; j++){
                    found.add(candidates[i]);
                }
            }
            
            rt.add(found);
            return;
            
        }
        
        if(sp >= stack.length){
            return;
        }
        
        int toadd = candidates[sp];
        
        for(int i = 0; cur + toadd * i <= target; i++ ){
            stack[sp] = i;
            search(sp + 1, cur + toadd * i);
            stack[sp] = 0;
        }
        
    }
 
 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        this.target = target;
        
        this.candidates = candidates;
        
        stack = new int[candidates.length];
        
        rt = new ArrayList<List<Integer>>();
        
        search(0, 0);
        
        return rt;
        
    }
}
