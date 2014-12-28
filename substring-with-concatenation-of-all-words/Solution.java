public class Solution {
    
    boolean checkCat(String s, HashMap<String, Integer> lm, int wordLen){
        
        while(s.length() > 0){
            String w = s.substring(0, wordLen);

            Integer v = lm.get(w);

            if(v == null) return false;
            if(v == 0) return false;

            s = s.substring(wordLen);

            v--;
            lm.put(w, v);
        }
        
        
        return true;
    }
    
    public List<Integer> findSubstring(String S, String[] L) {
        
        if(L.length == 0) return new ArrayList<Integer>();
        
        ArrayList<Integer> rt = new ArrayList<Integer>();
        

        HashMap<String, Integer> lm = new HashMap<String, Integer>();

        for(String l : L){

            Integer v = lm.get(l);

            if(v == null) v = 0;
            v++;

            lm.put(l, v);
        }


        final int wordLen = L[0].length();

        for(int i = 0; i + wordLen <= S.length(); i++){

            if(lm.containsKey(S.substring(i, i + wordLen))){

                if(i + wordLen * L.length > S.length()){
                    break;
                }

                if(checkCat(S.substring(i, i + wordLen * L.length), new HashMap<String, Integer>(lm), wordLen)){
                    rt.add(i);
                }
            }
        }

        return rt;
    }
}