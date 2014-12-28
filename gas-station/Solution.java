public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        
        int start = 0;
        int from_start = 0;
        
        int total = 0;
        
        for(int i = 0; i < gas.length; i++){
            int left = gas[i] - cost[i];
            total += left;
            from_start += left;
            
            if(from_start < 0){
                from_start = 0;
                start = i + 1; // restart from next station
            }
        }
        
        if(total >= 0){
            return start;
        } 
        
        return -1;
    }
}