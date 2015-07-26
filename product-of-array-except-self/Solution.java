public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        if(nums.length == 0) return output;

        output[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            output[i] = output[i - 1] * nums[i];
        }

        output[nums.length - 1] = output[nums.length - 2] * 1;

        int t = nums[nums.length - 1];
        for(int i = output.length - 2; i > 0 ; i--){
            output[i] = t * output[i - 1];
            t *= nums[i];
        }

        output[0] = t;

        return output;
    }
}
