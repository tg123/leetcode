public class Solution {
    public List<String> generateParenthesis(int n) {
        
        if (n == 0) return new ArrayList<String>();
        if (n == 1) return Arrays.asList(new String[]{"()"});
        
        HashSet<String> temp = new HashSet<String>();
        
        for(int i = 1; i < n ; i++){
            for(String s : generateParenthesis(n - i)){
                if(i == 1) temp.add("(" + s + ")");
                
                for(String ss : generateParenthesis(i)){
                              
                    temp.add(ss + s);
                    temp.add(s + ss);
                }
      
            }
        }
        
        return new ArrayList<String>(temp);
        
    }
}
