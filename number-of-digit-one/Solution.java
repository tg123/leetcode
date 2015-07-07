public class Solution {

    // return { highest digit, floor(n) }
    // 'floor' here has a naming problem...
    // named it exactly later
    // floor(101)   = 100
    // floor(92)    = 90
    // floor(10111) = 10000

    int[] N = {100000000, 10000, 100, 10};

    int[] extractHighest(int x){
        int e = 1;

        for(int n : N){
            if(x >= n){
                x /= n;
                e *= n;
            }
        }

        return new int[]{x, x * e};
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int countDigitOne(int n) {

        if(n <= 0) return 0;
        if(n < 10) return 1;

        Integer cached = cache.get(n);

        if(cached != null){
            return cached;
        }

        int[] e = extractHighest(n);

        int h = e[0];
        int f = e[1];

        int rest = n - f;

        int plus = 0;

        if(h == 1){
            plus = rest + 1;
        }

        int c = plus + countDigitOne(f - 1) + countDigitOne(rest);

        cache.put(n, c);

        return c;
    }
}
