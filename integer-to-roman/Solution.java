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
    
    public String intToRoman(int num) {
        
        String buff = "";
        char last = 0;
        int samecount = 0;
        
        while (num > 0){
            for(int i = N.length - 1; i >= 0; i--){
                if(num >= N[i]){
                    num -= N[i];
                    buff += C[i];
                    
                    if(last == C[i]){
                        samecount++;
                    }else{
                        samecount = 0;
                    }
                    
                    
                    if(samecount == 3){
                        int s = 5 * N[i];

                        buff = buff.substring(0, buff.length() - 4);

                        if(!buff.isEmpty() && buff.charAt(buff.length() - 1) == C[i + 1]){
                            s += N[i + 1];
                            buff = buff.substring(0, buff.length() - 1);
                        }


                        return buff + C[i] + intToRoman(s) + intToRoman(num);
                    }
                    
                    last = C[i];
                    break;
                }
            }
        }
        
        return buff;
        
    }
}