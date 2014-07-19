public class Solution {
    void swap(int x[], int a, int b) {
    	int t = x[a];
    	x[a] = x[b];
    	x[b] = t;
    }
    
    public boolean nextPermutation(int[] num) {
        
        if(num.length < 2) return false;
    
        int p = -1;
        
        for(int i = num.length - 1; i >0; i--){
            if(num[i] > num[i - 1]){
                 p = i - 1;
                 break;
            }
        }
        
        if(p == -1){
            Arrays.sort(num);
            return false;
        }
        
        int c = -1;
        for(int i = num.length - 1; i >=0; i--){
            if(num[i] > num[p]) {
                c = i;
                break;
            }
        }
        
        swap(num, p, c);
        Arrays.sort(num, p + 1, num.length);
        
        return true;
    }    
    
    ArrayList<Integer> asList(int[] num){
        ArrayList<Integer> l = new ArrayList<Integer>(num.length);
        for(int i = 0; i < num.length; i++)
            l.add(num[i]);
        
        return l;
    }
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> found = new ArrayList<ArrayList<Integer>>();
        found.add(asList(num));
        
        while(nextPermutation(num)){
            found.add(asList(num));
        }
        
        return found;
    }
}