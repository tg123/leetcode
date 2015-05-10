public class Solution {
    
    ArrayList<Integer>[] P;
    char[] S;
    ArrayList<String> rt;
    
    void joinAll(int offset, LinkedList<String> parents){
        
        if(P[offset].isEmpty()){
            
            rt.add(String.join(" ", parents));
            return;
        }
        
        for(Integer p : P[offset]){
            
            parents.push(new String(S, p, offset - p));
            
            joinAll(p, parents);
            
            parents.pop();
        }
        
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        S = s.toCharArray();

        P = new ArrayList[S.length + 1];
        P[0] = new ArrayList<Integer>();

        for(int i = 0; i < S.length; i++){
            for(int j = 0; j <= i; j++){
                String w = new String(S, j, i - j + 1);
                if(P[j] != null && dict.contains(w)){

                    if(P[i + 1] == null){
                        P[i + 1] = new ArrayList<Integer>();
                    }
                    
                    P[i + 1].add(j);
                }
            }
        }

        rt = new ArrayList<String>();
        
        if(P[S.length] != null){
            joinAll(S.length, new LinkedList<String>());
        }
        
        return rt;
    }
}
