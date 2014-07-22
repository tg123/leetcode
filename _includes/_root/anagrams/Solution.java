public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> found = new ArrayList<String>();
        
        HashMap<String, ArrayList<String>> box = new HashMap<String, ArrayList<String>>();
        
        for(String str : strs){
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            
            String key = new String(cstr);
            
            ArrayList<String> c = box.get(key);
            if(c == null){
                box.put(key , new ArrayList<String>());
            }
            
            c = box.get(key);
            c.add(str);
            
        }
        
        for(ArrayList<String> s : box.values()){
            
            if(s.size() > 1){
                found.addAll(s);
            }
            
        }
        
        return found;
    }
}