public class Solution {
    
    int toint(char c){
        if(c >= '0') return c - '0';
        return 0;
    }
    
    int toint(char[] chars, int index){
        if(index < chars.length  && index >=0 ) return toint(chars[index]);
        return 0;
    }
    
    public String addBinary(String a, String b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(a == null || b == null) return null;
        
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
    
        int n = Math.max(ca.length, cb.length);

        int[] s = new int[n + 1];
        
        
        //ca = Arrays.copyOf(ca , n);
        //cb = Arrays.copyOf(cb , n);
        
        for(int i = 0 ; i<n ; i++){
            
            s[i] += toint(ca, ca.length - 1 - i) + toint(cb, cb.length - 1 - i);
            s[i + 1] += s[i] / 2;
            s[i] %= 2;
        }
        
        String ss = "";
        
        for(int i = n - 1; i>=0; i--){
            ss =  ss + s[i];
        }
        
        if ( s[n] == 1 ) ss = "1" + ss;
        
        return ss;
        
    }
}