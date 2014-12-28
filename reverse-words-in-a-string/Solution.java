public class Solution {
    public String reverseWords(String s) {
        if(s == null) return null;
        
        
        ArrayList<String> words = new ArrayList<String>();
        
        StringBuilder buff = new StringBuilder();
        
        for(char c : (s + " ").toCharArray()){
            if (c != ' '){
                buff.append(c);
            }else{
                String w = buff.toString();
                if(!"".equals(w)){
                    words.add(w);
                    buff = new StringBuilder();
                }
            }
        }
        
        if(words.size() == 0) return "";
        
        buff = new StringBuilder();
        for(int i = words.size() - 1; i >0 ; i--){
            buff.append(words.get(i));
            buff.append(' ');
        }
        
        buff.append(words.get(0));
        
        return buff.toString();
        
    }
}