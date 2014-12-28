public class Solution {
    // http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
    void swap(int x[], int a, int b) {
    	int t = x[a];
    	x[a] = x[b];
    	x[b] = t;
    }
    
    public void nextPermutation(int[] num) {
        
        if(num.length < 2) return;
    
        int p = -1;
        
        for(int i = num.length - 1; i >0; i--){
            if(num[i] > num[i - 1]){
                 p = i - 1;
                 break;
            }
        }
        
        if(p == -1){
            Arrays.sort(num);
            return;
        }
        
        int c = -1;
        for(int i = num.length - 1; i >=0; i--){
            if(num[i] > num[p]) {
                c = i;
                break;
            }
        }
        
        swap(num, p, c);
        Arrays.sort(num, p + 1, num.length);
        
    }
}