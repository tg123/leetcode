public class Solution {
    
    boolean isPal(String s){

        char[] S = s.toCharArray();

        for(int i = 0; i < S.length / 2; i++){
            if(S[i] != S[S.length - i - 1])
                return false;
        }

        return true;
    }
    

    
    public List<List<String>> partition(String s) {

        List<List<String>> rt = new ArrayList<List<String>>();

        if("".equals(s)) return rt;
        if(s.length() == 1) return Arrays.asList(Arrays.asList(s));
        
        for(int i = 0; i < s.length(); i++){
            String x = s.substring(0, i + 1);
            if(isPal(x)){
                List<List<String>> sub = partition(s.substring(i + 1));

                if(sub.isEmpty()){
                    rt.add(Arrays.asList(x));
                } else {
                    for(List<String> l : sub){
                        ArrayList<String> _l = new ArrayList<String>();
                        _l.add(x);
                        _l.addAll(l);
                        rt.add(_l);
                    }
                }
            }
        }
        
        return rt;
        
    }
}