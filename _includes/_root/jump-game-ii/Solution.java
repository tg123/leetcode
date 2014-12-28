public class Solution {
    public int jump(int[] A) {
        int count = 0;
        int laststep = 0;

        for(int i = 0; i < A.length - 1; /**/){

            int maxstep = i + A[i];
            for(int j = laststep + 1; j <= i; j++){
                maxstep = Math.max(maxstep, j + A[j]);
            }

            laststep = i;
            i = maxstep;

            count++;
        }
        
        return count;
    }
}