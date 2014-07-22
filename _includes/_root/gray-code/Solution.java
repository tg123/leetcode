public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        
        ArrayList<Integer> rt = new ArrayList<Integer>();
        
        
        for(int i = 0; i < Math.pow(2, n); i++){
            // G(N) = (B(n)/2) XOR B(n)
            rt.add((i / 2) ^ i);
        }
        
        return rt;
        
    }
}