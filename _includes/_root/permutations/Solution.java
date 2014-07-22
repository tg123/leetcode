public class Solution {
    
    int[] resetof(int[] num, int index){
        int[] rt = new int[num.length - 1];
        int s = 0;
        for(int i = 0; i < num.length ; i++)
            if(i != index) rt[s++] = num[i];
        
        return rt;
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<ArrayList<Integer>> rt = new ArrayList<ArrayList<Integer>>();
        
        if(num.length == 0){
            // do nothing
        }else if(num.length == 1) {
            rt.add(new ArrayList<Integer>(Arrays.asList(num[0])));
        }else{
            
            for(int i = 0; i < num.length; i++){
                for(ArrayList<Integer> l : permute(resetof(num, i))){
                    l.add(num[i]);
                    rt.add(l);
                };
            }   
            
        }
        
        return rt;
        
    }
}