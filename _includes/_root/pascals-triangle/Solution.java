public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> rt = new ArrayList<ArrayList<Integer>>();
        Integer[] prev = null;
        for(int i = 1 ; i <= numRows; i++){
            
            //ArrayList<Integer> row = new ArrayList<Integer>(i);
            
            //row.add(0, 1);
            //row.add(i - 1, 1);
            
            Integer[] row = new Integer[i];
            
            row[0] = 1;
            row[i - 1] = 1;
            
            for(int j = 1; j < i - 1 ; j++){
                //row.add(j, prev.get(j) + prev.get(j -1));
                row[j] = prev[j] + prev[j - 1];
            }
            
            rt.add(new ArrayList<Integer>(Arrays.asList(row)));
            prev = row;
        }
        
        
        return rt;
    }
}