public class Solution {
    
    /*
    http://en.wikipedia.org/wiki/Roman_numerals
    I	1
    V	5
    X	10
    L	50
    C	100
    D	500
    M	1,000
    
    to avoid four characters being repeated in succession
    */
    
    static final int[]  N = { 1 ,  5,  10,  50,  100,  500,  1000 };
    static final char[] C = {'I', 'V', 'X', 'L', 'C' , 'D',  'M' };
    
    int index(char c){
        for(int i = 0 ; i < C.length; i++){
            if (C[i] == c)
                return i;
        }
        
        return -1;
    }
    
    int rtoi(char c){
        return N[index(c)];
    }
    
    public int romanToInt(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(s.length() <= 0) return 0;
        
        char[] cs = s.toCharArray();
        
        int sum = rtoi(cs[0]);
        
        for (int i = 1 ; i < cs.length; i++){
            sum += rtoi(cs[i]);
            
            int j = i - 1;
            int ci = index(cs[i]);
            
            while(j>=0 && index(cs[j]) < ci){
                sum -= rtoi(cs[j--]) * 2;
            }
        }
        
        
        return sum;
    }
}