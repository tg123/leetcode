public class Solution {
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] result = new int[digits.length + 1];
        digits[digits.length - 1] += 1;
        for(int i = digits.length - 1; i >=0 ; i--){
            result[ i + 1 ] += digits[i];
            result[ i ] += result[ i + 1 ] / 10;
            result[ i + 1 ] %= 10;
        }
        
        if(result[0] == 0) return Arrays.copyOfRange(result, 1 , result.length);
        else
        return result; 
    }
}