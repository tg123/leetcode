public class Solution {

    int trans(int n){
        int s = 0;

        do{
            int t = n % 10;

            s += t * t;

            n /= 10;

        } while(n > 0);

        return s;
    }

    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();

        for(;;) {

            n = trans(n);

            if(n == 1) return true;

            if(s.contains(n)) return false;

            s.add(n);
        }

    }
}
