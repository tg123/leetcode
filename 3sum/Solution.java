public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> found = new ArrayList<ArrayList<Integer>>();
        
        int pneg = 0 , ppos = num.length - 1;
        
        
        while(ppos > 0 && num[ppos] >= 0){
            while(pneg < ppos && num[pneg] <= 0 && num[ppos] >= 0){
                int sum = num[pneg];
                sum += num[ppos];
                
                for(int i  = pneg + 1; i < ppos; i++){
                    if(num[i] + sum == 0){
                        found.add(new ArrayList<Integer>(
                            Arrays.asList(new Integer[]{num[pneg], num[i] ,num[ppos]})
                        ));
                        
                        break;
                    }
                }
                
                int old = num[pneg];
                while(pneg < ppos && num[pneg] == old) pneg++;                
            }
            
            pneg = 0;
            
            int old = num[ppos];
            while(ppos > 0 && num[ppos] == old) ppos--;
        }
        
        
        return found;
    }
}