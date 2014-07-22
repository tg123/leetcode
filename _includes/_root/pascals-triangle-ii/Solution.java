public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Integer[] row = new Integer[rowIndex + 1];
        
        //row[0] = 1;
        //row[rowIndex] = 1;
        Arrays.fill(row, 1);
        
        for(int i = 0 ; i < rowIndex - 1; i++)
        for(int j = i + 1; j >= 1; j--){
            row[j] = row[j] + row[j - 1];
        }
        
        return new ArrayList<Integer>(Arrays.asList(row));
    }
}