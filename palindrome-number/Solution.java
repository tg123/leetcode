public class Solution {
    
    int len(int x){
        return (int) Math.log10(x) + 1;
    }
    
    int charAt(int x, int i){
        return (int) (x / Math.pow(10, i)) % 10;
    }
    
    public boolean isPalindrome(int x) {
        if (x < 0 ) return false;
        if (x == 0) return true;
        
        int l = len(x);
        
        for(int i = 0; i < l / 2; i++){
            if(charAt(x, i) != charAt(x, l - i - 1)){
                return false;
            }
        }
        
        return true;
    }
}
