public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if (n == 0) return new ArrayList<String>();
        if (n == 1) return new ArrayList<String>(Arrays.asList(new String[]{"()"}));
        
        HashSet<String> temp = new HashSet<String>();
        
        for(int i = 1; i < n ; i++)
        for(String s : generateParenthesis(n - i)){
            if(i == 1) temp.add("(" + s + ")");
            
            for(String ss : generateParenthesis(i)){
                          
                temp.add(ss + s);
                temp.add(s + ss);
            }
  
        }
        
        return new ArrayList<String>(temp);
        
    }
}