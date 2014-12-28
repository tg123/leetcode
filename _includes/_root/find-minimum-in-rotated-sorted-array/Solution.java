public class Solution {
    public int findMin(int[] num) {

        if(num.length == 1) return num[0];
        if(num.length == 2) return Math.min(num[0], num[1]);

        int s = 0;
        int e = num.length;

        int m = (s + e) / 2;

        // s < m < e
        if ( num[s] < num[m] && num[m] < num[e - 1]){
            return num[s];
        }

        // s < m > e
        if ( num[s] < num[m] && num[m] > num[e - 1]){
            return findMin(Arrays.copyOfRange(num, m, e));
        }

        // s > m < e
        return findMin(Arrays.copyOfRange(num, s, m + 1));
    }
}
