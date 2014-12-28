public class Solution {
    
    int[] resetof(int[] num, int index){
        int[] rt = new int[num.length - 1];
        int s = 0;
        for(int i = 0; i < num.length ; i++)
            if(i != index) rt[s++] = num[i];
        
        return rt;
    }
    
    public List<List<Integer>> permute(int[] num) {
        
        ArrayList<List<Integer>> rt = new ArrayList<List<Integer>>();
        
        if(num.length == 0){
            // do nothing
        }else if(num.length == 1) {
            rt.add(new ArrayList<Integer>(Arrays.asList(num[0])));
        }else{
            
            for(int i = 0; i < num.length; i++){
                for(List<Integer> l : permute(resetof(num, i))){
                    l.add(num[i]);
                    rt.add(l);
                };
            }   
            
        }
        
        return rt;

        
    }
}
