public class Solution {
    
    
    ArrayList<String> collect;
    
    String[] stack;
    
    void findnum(String s, int p, int pstack){
        
        if(pstack == 4){
            
            if(p >= s.length()){
                String ip = "" + stack[0] + "." + stack[1] + "." + stack[2] + "." + stack[3];
                
                String _ip = "" + stack[0] + stack[1] + stack[2] + stack[3]; //shame
                
                if(s.equals(_ip)){
                    collect.add(ip);
                }
                    
            }
            
            return;
        }
        
        for(int i = 1; i <= 3; i++){
            
            if( p + i > s.length())
                return;
            
            String test = s.substring(p, p + i);
            
            if(Integer.valueOf(test) <= 255){
                stack[pstack] = "" + Integer.valueOf(test);
                findnum(s, p + i, pstack + 1);
            } 
            
        }
    }
    
    public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        collect = new ArrayList<String>();
        stack = new String[4];
        
        findnum(s, 0 , 0);
        
        return collect;
        
    }
}