public class Solution {
    
    String countAndSay(String prev){
        
        char[] str = prev.toCharArray();
        
        int p = 1;
        int count = 1;
        char last = str[0];
        
        String s = "";
        
        while(p < str.length){
            
            if(str[p] == last){
                count++;
                
            }else{
                
                s += "" + count + last;
                
                last = str[p];
                count = 1;
            }
            
            p++;
        }
        
        s += "" + count + last;
        
        return s;
    }
    
    public String countAndSay(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String init = "1";
        
        for(int i = 0; i < n - 1; i++){
            init = countAndSay(init);
        }
        
        return init;
        
    }
}