public class Solution {
    public int longestConsecutive(int[] num) {
        
        HashSet<Integer> nums = new HashSet<Integer>();
        
        for(int n : num){
            nums.add(n);
        }
        
        int longest = 0;
        
        for(final int n : num){
            
            int l = 1;

            int nn = n;
            
            nums.remove(n);
            
            while(nums.contains(++nn)){
                l++;
                nums.remove(nn);
            } 
            
            nn = n;
                        
            while(nums.contains(--nn)){
                l++;
                nums.remove(nn);
            } 
            
            longest = Math.max(longest, l);
        }
        
        return longest;
        
    }
}