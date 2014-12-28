public class Solution {
    public String convert(String s, int nRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        //row = 4
        /*
          *     *     *  
          *   * *   *
          * *   * * 
          *     *
          |r-2+1|
          
          col = (row - 2 + 1) * (len(s) / (row + row - 2) + 1)
        */
        
        if(nRows == 1) return s;
        
        int nCols = (nRows - 2 + 1) * (s.length() / (nRows + nRows - 2) + 1);
        char[][] paper = new char[nCols][nRows]; 
        
        //int ps = 0;
        char[] str = s.toCharArray();
        
        int pr = 0, pc = 0;
        
        boolean direction = false; // true for down false for up , start up = come from up
        
        
        for(char c : str){
            paper[pc][pr] = c;

            if(pr == 0 || pr == nRows - 1){
                direction = !direction;
            }            
            
            if(direction){
                pr++;
            }else{
                pr--;
                pc++;
            }
        }
        
        String rt = "";
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(paper[j][i] != 0){
                    rt += paper[j][i];
                }
            }
        }
        
        return rt;
         
    }
}