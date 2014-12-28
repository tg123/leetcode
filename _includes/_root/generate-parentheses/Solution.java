public class Solution {
    public List<String> generateParenthesis(int n) {
        
        if (n == 0) return new ArrayList<String>();
        if (n == 1) return Arrays.asList(new String[]{"()"});
        
        HashSet<String> temp = new HashSet<String>();
        
        for(String s : generateParenthesis(n - 1)){
            temp.add("(" + s + ")");
            temp.add("()" + s);
            temp.add(s + "()");
        }
        
        for(int i = 2; i < n - 1 ; i++){
            for(String s : generateParenthesis(n - i)){
                for(String ss : generateParenthesis(i)){

                    temp.add(ss + s);
                    temp.add(s + ss);
                }

            }
        }
        
        return new ArrayList<String>(temp);
    }
}
