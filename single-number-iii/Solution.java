public class Solution {
    public int[] singleNumber(int[] nums) {
        int aXORb = nums[0];

        for(int i = 1; i < nums.length; i++){
            aXORb ^= nums[i];
        }

        // this bit either in a or b
        int bit = Integer.lowestOneBit(aXORb);

        int a = 0;
        for(int n : nums){
            if((n & bit) == bit){
                a ^= n;
            }
        }

        return new int[]{a, aXORb ^ a};
    }
}
