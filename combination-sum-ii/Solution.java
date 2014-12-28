public class Solution {
    int target;
    
    int[] candidates;
    
    int[] stack;
    
    ArrayList<List<Integer>> rt;
    
    HashSet<String> block;
    
    void search(int sp, int cur){

        if(cur == target){
            ArrayList<Integer> found = new ArrayList<Integer>();
            for(int i = 0; i < stack.length; i++){
                for(int j = 0; j < stack[i]; j++){
                    found.add(candidates[i]);
                }
            }
            
            String uid = found.toString();
            
            if(!block.contains(uid)){
                rt.add(found);
                block.add(uid);
            }
            return;
            
        }
        
        if(sp >= stack.length){
            return;
        }
        
        int toadd = candidates[sp];
        
        for(int i = 0; cur + toadd * i <= target && i <= 1; i++ ){
            stack[sp] = i;
            search(sp + 1, cur + toadd * i);
            stack[sp] = 0;
        }
        
    }    
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        
        candidates = num;
        this.target = target;
        
        stack = new int[candidates.length];
        
        rt = new ArrayList<List<Integer>>();
        
        block = new HashSet<String>();
        
        search(0, 0);
        
        return rt;
        
    }
}
