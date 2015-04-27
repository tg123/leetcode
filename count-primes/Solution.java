public class Solution {
    public int countPrimes(int n) {

        if(n < 2) return 0;

        BitSet b = new BitSet();

        b.set(0);
        b.set(1);

        for(int p = 2; p * 2 < n ; p = b.nextClearBit(p + 1)){
            for(int i = 2; p * i < n ;i++){
                b.set(p * i);
            }
        }

        b.flip(0, n);

        return b.cardinality();
    }
}
