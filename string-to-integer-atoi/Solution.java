public class Solution {
    public int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        
        // null "" 
        if (str == null || "".equals(str))
            return 0;
        
        char[] ds = str.toCharArray();
        
        int sum = 0;
        
        int sign = 1;
        
        int s = 0;
        
        boolean signseen = false;
        
        while(s < ds.length && !('0' <= ds[s] && ds[s] <= '9')){
            
            if(signseen)
                return 0;
                
            
            
            if(ds[s] == '-'){
                sign *= -1;
                signseen = true;
            }else if(ds[s] == '+'){
                signseen = true;
            }else if(ds[s] != ' '){
                return 0;
            }
            
            s++;
        }
        
        int e = s;
        while(e < ds.length && ('0' <= ds[e] && ds[e] <= '9')){
            e++;
        }
        
        int p = 0;
        
        boolean flago = false;
        for(int i  = s; i < e ; i++){

            if(sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && ds[i] - '0' > Integer.MAX_VALUE % 10 ))
                flago = true;
                
            sum = sum * 10 + (ds[i] - '0');
        }
        
        if (flago)
            if(sign > 0)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
                
        return sum * sign;
        
    }
}