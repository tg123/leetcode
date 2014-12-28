public class Solution {
    public int threeSumClosest(int[] num, int target) {
        
        if(num.length < 3) return 0;
        
        Arrays.sort(num);
        
        int pneg = 0 , ppos = num.length - 1;
        
        int closest = num[0] + num[1] + num[2];
        
        while(ppos > 0){
            while(pneg < ppos){
                int sum = num[pneg];
                sum += num[ppos];
                
                for(int i  = pneg + 1; i < ppos; i++){
                    if(Math.abs(target - (num[i] + sum)) < Math.abs(target - closest) ){
                        closest = num[i] + sum;
                    }
                }
                
                int old = num[pneg];
                while(pneg < ppos && num[pneg] == old) pneg++;                
            }
            
            pneg = 0;
            
            int old = num[ppos];
            while(ppos > 0 && num[ppos] == old) ppos--;
        }
        
        
        return closest;
    }
}