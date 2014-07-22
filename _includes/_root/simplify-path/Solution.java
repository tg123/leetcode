public class Solution {
    public String simplifyPath(String path) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        
        if(path == null) return null;

        String[] names = path.split("/");
        LinkedList<String> stack = new LinkedList<String>(Arrays.asList(names));
        
        String r = "";
        int eat = 0;
        while(stack.size() > 0){
            String n = stack.pollLast();
            if("..".equals(n)) {
                eat++;
            }
            else if(".".equals(n)) { 
                //if(eat>0) eat--; 
            }
            else if(!"".equals(n)){
                if(eat > 0) eat--;
                else{
                    r = "/" + n + r;
                }
            }
        }
        
        if("".equals(r)) r = "/";
        
        return r;
        
    }
}