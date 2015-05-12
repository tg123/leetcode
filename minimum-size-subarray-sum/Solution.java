public class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0;

        int st = 0;

        int c = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(sum >= s){
                while(sum - nums[st] >= s) {
                    sum -= nums[st++];
                }

                c = Math.min(c, i - st + 1);
            }

        }

        if(c > nums.length) {
            return 0;
        }

        return c;
    }
}
