public class Solution {
    
    final int STACK_SIZE = 10;
    
    String[] stack;
    ArrayList<String> found;
    
    void pushWord(int p, String word){
        while(p >= stack.length){
            stack = Arrays.copyOf(stack, stack.length + STACK_SIZE);
        }
                    
        stack[p] = word;
    }
    
    void wordBreak(String s, Set<String> dict, final int p){
        if("".equals(s) || s == null){
            
            if ( p > 0){
                String join = stack[0];
                for(int i = 1; i < p ; i++){
                    join += " " + stack[i];
                }
                
                found.add(join);
            }
            
            return;
        }
        
        for(String d : dict){
            if(s.startsWith(d)){

                int l = d.length();
                pushWord(p, d);

                wordBreak(s.substring(l), dict, p + 1);
            }
        }
        
    }
    
    boolean _wordBreak(String s, Set<String> dict) {
        
        char[] S = s.toCharArray();
        
        boolean[] P = new boolean[S.length + 1];
        P[0] = true;
        
        for(int i = 0; i < S.length; i++){
            
            for(int j = 0; j <= i; j++){
                if(P[j] && dict.contains(new String(S, j, i - j + 1))){
                    P[i + 1] = true;
                    continue;
                }
            }
        }
        
        return P[S.length];
        
        
    }
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        found = new ArrayList<String>();
        
        if(_wordBreak(s, dict)){
            if(dict.size() <= 0) return found;
            stack = new String[STACK_SIZE];
    
            wordBreak(s, dict, 0);
        }
        
        return found;
    }
}