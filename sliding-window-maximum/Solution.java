public class Solution {

    static class SlidingMaxQueue {

        int[] nums;
        int k;

        LinkedList<Integer> queue = new LinkedList<>();

        SlidingMaxQueue(int[] nums, int k){
            this.nums = nums;
            this.k = k;
        }

        int max(){
            return nums[queue.peekFirst()];
        }

        void add(int i){

            if(i >= nums.length) return;

            // remove invalid index
            while(!queue.isEmpty() && queue.peekFirst() <= i - k){
                queue.pollFirst();
            }

            // remove nums < current;
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }

            queue.add(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] T = new int[Math.min(nums.length - k + 1, nums.length)];

        SlidingMaxQueue Q = new SlidingMaxQueue(nums, k);

        Q.add(0);

        for(int i = 1; i <= nums.length; i++){
            T[Math.max(i - k, 0)] = Q.max();
            Q.add(i);
        }

        return T;
    }
}
