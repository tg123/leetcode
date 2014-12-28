public class Solution {

    public int ladderLength(String start, String end, Set<String> dict) {
        
        LinkedList<String> queue = new LinkedList<String>();
        final String END = new String();
        
        queue.add(start);
        queue.add(END);
        
        int level = 0;
        HashSet<String> vi = new HashSet<String>();
        
        while(!queue.isEmpty()){
            
            String current = queue.poll();
            
            if(current == END){
                level++;
                
                if(!queue.isEmpty()) queue.add(END);
            }else{
                
                if(end.equals(current))
                    return level + 1;
                
                char[] word = current.toCharArray();
                
                for(int i = 0; i < word.length; i++){
                    
                    char old = word[i];
                    
                    for(char j = 'a'; j <= 'z' ; j++){
                        
                        if(j == old)
                            continue;
                        
                        word[i] = j;
                        
                        String s = new String(word);
                        
                        if(dict.contains(s) && !vi.contains(s)){
                            queue.add(s);
                            vi.add(s);
                        }
                        
                    }
                    
                    word[i] = old;
                }
                
            }
            
        }
        
        return 0;
        
    }
}
