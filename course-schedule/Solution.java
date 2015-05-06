public class Solution {
    
    static class Vertex {
        
        int id;
        
        Vertex(int id){
            this.id = id;
        }
        
        Set<Integer> in  = new HashSet<>();
        Set<Integer> out = new HashSet<>();
        
        boolean isSink(){
            return out.isEmpty();
        }
    }
    
    Vertex safe(Vertex[] G, int id){
        if(G[id] == null){
            G[id] = new Vertex(id);
        }
        
        return G[id];
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Vertex[] G = new Vertex[numCourses];
        
        for(int[] p : prerequisites){
            safe(G, p[0]).out.add(p[1]);
            safe(G, p[1]).in.add(p[0]);
        }
        
        Set<Vertex> S = Arrays.stream(G)
                            .filter(v -> v != null)
                            .collect(Collectors.toSet());
        

        loop:
        while(!S.isEmpty()){
            
            for(Vertex v : S){
                if(v.isSink()){
                    S.remove(v);
                    
                    for(int i : v.in){
                        G[i].out.remove(v.id);
                    }
                    
                    continue loop;
                }
            }
            
            return false;
        }
        
        return true;
    }
}
