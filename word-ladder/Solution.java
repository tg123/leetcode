public class Solution {
    
    static final Object END = new Object();
    
    boolean isConnect(String from, String to){
        char[] _from = from.toCharArray();
        char[] _to = to.toCharArray();
        
        int countdiff = 0;
        for(int i = 0; i < _from.length; i++){
            if (_from[i] != _to[i])
                countdiff++;
        }
        
        return countdiff == 1;
    }
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        Deque queue = new LinkedList();
        
        queue.add(start);
        queue.add(END);
        
        int level = 0;
        HashSet<String> vi = new HashSet<String>();
        
        while(!queue.isEmpty()){
            Object el = queue.poll();
            
            boolean flag = false; // added ele
            
            while (el != END){
               
                String w = (String) el;
            
                if(end.equals(w))
                    return level + 1;
                
                char[] sw;
                
                for(int i = 0; i < w.length(); i++){
                    sw = w.toCharArray();
                    for(char j = 'a'; j <= 'z' ; j++){
                        
                        sw[i] = j;
                        
                        String s = new String(sw);
                        
                        if(s.equals(w))
                            continue;
                        
                        if(dict.contains(s) && !vi.contains(s)){
                            queue.add(s);
                            vi.add(s);
                            flag = true;
                        }
                        
                    }
                }
                
                //dict.removeAll(queue);
               
                el = queue.poll(); 
            }
            
            level++;
            
            if(flag)
                queue.add(END);
            
        }
        
        
        return 0;
        
    }
}