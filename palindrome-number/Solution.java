public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        
        if(x < 0) return false;
        
        if(x == 0) return true;
        
        int size = (int)Math.log10(x);
        
        int mid = size / 2;
        
        for(int i = 0; i <= mid; i++){
            
            int p = (int) (x / Math.pow(10, i)) % 10;
            int q = (int) (x / Math.pow(10, size - i)) % 10;
            if(p != q)
                return false;
            
        }
        
        return true;
    }
}