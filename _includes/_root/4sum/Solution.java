public class Solution {
    
    static class TwoSum {
        int index1;
        int index2;
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> found = new ArrayList<List<Integer>>();
        
        if(num.length < 4) return found;
        
        Arrays.sort(num);
        
        HashMap<Integer, ArrayList<TwoSum>> cache = new HashMap<Integer, ArrayList<TwoSum>>();
        
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                int s = num[i] + num[j];
                TwoSum t = new TwoSum();
                
                t.index1 = i;
                t.index2 = j;
                
                ArrayList<TwoSum> l = cache.get(s);
                if(l == null){
                    l = new ArrayList<TwoSum>();
                    cache.put(s, l);
                }
                
                l.add(t);
            }
        }
        
        HashSet<String> block = new HashSet<String>();
        
        for(Integer a : cache.keySet()){
            Integer b = target - a;
            
            ArrayList<TwoSum> lsb = cache.get(b);
            if(lsb != null){
                ArrayList<TwoSum> lsa = cache.get(a);
                
                for(TwoSum sa : lsa)
                for(TwoSum sb : lsb){
                    
                    if(sa == sb) continue;

                    Integer[] sol = new Integer[]{sa.index1, sa.index2, sb.index1, sb.index2};
                    Arrays.sort(sol);
                    
                    if(sol[0] == sol[1]) continue;
                    if(sol[1] == sol[2]) continue;
                    if(sol[2] == sol[3]) continue;
                    
                    sol = new Integer[]{num[sol[0]], num[sol[1]], num[sol[2]], num[sol[3]]};
                    
                    String uid = Arrays.toString(sol);
                    if(!block.contains(uid)){
                        found.add(Arrays.asList(sol));
                        
                        block.add(uid);
                    }
                    
                    
                }
            }
        }
        
        
        return found;
    }
}
