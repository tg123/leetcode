public class Solution {
    
    String space(int len){
        char[] s = new char[len];
        Arrays.fill(s, ' ');
        return new String(s);
    }
    
    public List<String> fullJustify(String[] words, int L) {
        
        ArrayList<String> text = new ArrayList<String>();
        
        int p = 0;
        int lastp = 0;
        while(p < words.length){
            
            if(L == 0 && "".equals(words[p])){
                text.add("");
                p++;
                continue;
            }
            
            int l = 0;
            while(l < L && p < words.length){
                l += words[p++].length() + 1;
            }
            
            if(l - 1 > L) l -= words[--p].length() + 1;
            
            int count = p - lastp;
            int left = L - l + count;
            
            int add;
            if(count == 1) add = left;
            else if (p - 1 == words.length - 1) { add = 1; left = count - 1;} // fuck...
            else add = left / ( count - 1);

            left -= add * (count - 1);

            String s = "";
            for(int i = lastp; i < p - 1; i++){
                if(left > 0){
                    s += words[i] + space(add + 1);
                    left--;
                }else{
                    s += words[i] + space(add);
                }
            }
            
            left = L - s.length() - words[p - 1].length();
            
            if(count == 1 || p - 1 == words.length - 1) // fuck...
            s += words[p - 1] + space(left);
            else
            s += space(left) + words[p - 1];
            
            text.add(s);
            lastp = p;
        }
        
        return text;
        
    }
}
