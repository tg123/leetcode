public class Solution {
    public int rob(int[] num) {
        if(num.length == 0) return 0;
        if(num.length == 1) return num[0];
        
        int[] P = new int[num.length];
        
        P[0] = num[0];
        P[1] = Math.max(num[0], num[1]);

        for(int i = 2; i < num.length; i++){
            P[i] = Math.max(num[i] + P[i - 2], P[i - 1]);
        }
        
        return P[num.length - 1];
    }
}
