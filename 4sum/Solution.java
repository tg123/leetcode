public class Solution {
    
    static class TwoSum {
        int index1;
        int index2;
        
        boolean overlap(TwoSum other){
            if(this == other) return true;
            
            if(index1 == other.index1) return true;
            if(index2 == other.index1) return true;
            
            if(index1 == other.index2) return true;
            if(index2 == other.index2) return true;
            
            return false;
        }
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> found = new ArrayList<List<Integer>>();
        
        if(num.length < 4) return found;
        
        HashMap<Integer, ArrayList<TwoSum>> cache = new HashMap<Integer, ArrayList<TwoSum>>();
        
        Arrays.sort(num);
        
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
                    
                    if(sa.overlap(sb)) continue;
                    
                    Integer[] sol = new Integer[]{num[sa.index1], num[sa.index2], num[sb.index1], num[sb.index2]};
                    Arrays.sort(sol);
                    
                    String uid = Arrays.toString(sol);
                    if(!block.contains(uid)){
                        found.add(Arrays.asList(sol));
                        
                        block.add(uid);
                    }
                    
                    
                }
                
                cache.put(a, null);
                cache.put(b, null);
            }
        }
        
        
        return found;
    }
}
