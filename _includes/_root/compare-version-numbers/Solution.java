public class Solution {
    
    String padding(String s, int len){
        if(s == null) s = "";
        
        char[] p = new char[len - s.length()];
        
        Arrays.fill(p, '0');
        
        return new String(p) + s;
    }
    
    int len(String s){
        if(s == null) return 0;
        return s.length();
    }
    
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int m = Math.max(v1.length, v2.length);
        
        v1 = Arrays.copyOf(v1, m);
        v2 = Arrays.copyOf(v2, m);
        
        for(int i = 0; i < m; i++){
            String s1 = v1[i];
            String s2 = v2[i];
            
            int l = Math.max(len(s1), len(s2));
            
            s1 = padding(s1, l);
            s2 = padding(s2, l);
            
            for(int j = 0; j < l; j++){
                if(s1.charAt(j) > s2.charAt(j)){
                    return 1;
                }else if(s1.charAt(j) < s2.charAt(j)){
                    return -1;
                }
            }
            
        }
        
        return 0;
    }
}
