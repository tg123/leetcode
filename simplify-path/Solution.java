public class Solution {
    public String simplifyPath(String path) {
        
        String[] names = path.split("/");
        
        int eat = 0;
        
        LinkedList<String> stack = new LinkedList<String>();
        
        for(int i = names.length - 1; i >= 0; i--){
            
            String token = names[i];
            
            if("..".equals(token)){
                eat++;
            }else if(".".equals(token)){
                // do nothing
            }else if("".equals(token)){
                // do nothing
            }else {
                
                // dir name
                if(eat > 0){
                    eat--;
                }else{
                    stack.push(token);
                }
            }
        }
        
        StringBuilder s = new StringBuilder();
        
        s.append("/");
        
        while(stack.size() > 1){
            s.append(stack.pop());
            s.append("/");
        }
        
        if(!stack.isEmpty()) s.append(stack.pop());
        
        return s.toString();
    }
}
