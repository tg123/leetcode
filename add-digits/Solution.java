public class Solution {
    public int addDigits(int num) {
        return num - (num - 1) / 9 * 9;
    }
}
