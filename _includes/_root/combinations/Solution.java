public class Solution {
    
    Integer[] num;
    Integer[] stack;
    int target;
    
    ArrayList<ArrayList<Integer>> found;
    
    
    void search(int p){
        if(p == target){
            
            found.add(new ArrayList(Arrays.asList(stack)));
            return;
        }
        
        for(Integer n : num){
            if(p > 0 && n <= stack[p - 1]) continue;
            
            stack[p] = n;
            search(p + 1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
        target = k;
        
        num = new Integer[n];
        for(int i = 1; i <= n; i++) num[i - 1] = i;
        
        stack = new Integer[k];
        
        found = new ArrayList<ArrayList<Integer>>();
        
        search(0);
        
        return found;
        
    }
}