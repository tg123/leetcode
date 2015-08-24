public class Solution {

    void swap(int[] nums, int i, int j){
        int t   = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    void sort(int[] nums){

        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i){
                if(nums[i] < 0) break;

                if(nums[i] >= nums.length) {
                    nums[i] = -1;
                    break; // drop
                }

                swap(nums, nums[i], i);
            }
        }
    }

    public int missingNumber(int[] nums) {
        sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }

        return nums.length;
    }
}
