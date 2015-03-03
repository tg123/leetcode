public class Solution {
    public void rotate(int[] nums, int k) {
        
        if(k == 0) return;


        int c = 0;

        for(int j = 0; j < k; j++) {
            int i = j;
            int t = nums[i];


            for (;;) {

                i = (i + k) % nums.length;

                int nt = nums[i];

                nums[i] = t;

                t = nt;

                c++;

                if (i == j) break;
            }

            if(c == nums.length) break;
        }
        
    }
}
