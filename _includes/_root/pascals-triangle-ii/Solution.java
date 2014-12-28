public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        
        Arrays.fill(row, 1);
        
        for(int i = 0 ; i < rowIndex - 1; i++){
            for(int j = i + 1; j >= 1; j--){
                row[j] = row[j] + row[j - 1];
            }
        }
        
        return Arrays.asList(row);
    }
}
