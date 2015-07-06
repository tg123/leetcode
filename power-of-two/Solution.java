public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        if(n == 1) return true;

        if(n % 2 == 1) return false;

        return isPowerOfTwo(n / 2);
    }
}
