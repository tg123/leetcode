public class Solution {
    public int sqrt(int x) {
        
        if(x <  0) return -1;
        if(x == 0) return 0;
        
        int s = 0; 
        int e = x;
        
        
        while(s < e){
            int m = (e - s) / 2 + s;

            int m1 = x / (m + 1);
            int m2 = x / (m + 1 + 1);

            if(m + 1 == m1){
                return m + 1;
            }

            if(m + 1 + 1 == m2){
                return m + 1 + 1;
            }

            if(m + 1 < m1 && m2 < m + 1 + 1){
                return m + 1;
            }


            if(m1 < m + 1){
                e = m;
            }else{
                s = m + 1;
            }

        }


        throw new RuntimeException();
    }
}
