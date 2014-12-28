public class Solution {
    
    ArrayList<String> collect;
    
    String[] stack;
    
    void findnum(String s, int p, int pstack){
        
        if(pstack == 4){
            
            if(p >= s.length()){
                String ip = "" + stack[0] + "." + stack[1] + "." + stack[2] + "." + stack[3];
                
                collect.add(ip);
            }
            
            return;
        }
        
        for(int i = 1; i <= 3; i++){
            
            if( p + i > s.length())
                return;
            
            String number = s.substring(p, p + i);
            
            if(i > 1 && s.charAt(p) == '0') continue;
            
            if(Integer.parseInt(number) <= 255){
                stack[pstack] = number;
                findnum(s, p + i, pstack + 1);
            } 
            
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        
        collect = new ArrayList<String>();
        stack = new String[4];
        
        findnum(s, 0 , 0);
        
        return collect;
    }
}
