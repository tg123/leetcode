## [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock) k times like [Best Time to Buy and Sell Stock III](../best-time-to-buy-and-sell-stock-iii)

 _Note: This is a TLE version. `O(n^3)`. but, easier to understand_
 
 ```
         |
         |   * * 
  *      |  *   * *
 * *     | *       *
*   *    |*         *
     *   |           *   * *
      * *|            * *
         |             *
         |
         i
```         

`day i` separates days into `0..i` and `i..end`.
just assume that you know max profit `k - 1` times for `0..i` day is `maxProfit(k - 1, 0..i)`.

such that

the max profit of buy and sell only once after `day i` is `maxProfit(k - 1, 0..i) + maxProfit(1, i..end)`.
just do as [Best Time to Buy and Sell Stock III](../best-time-to-buy-and-sell-stock-iii), 
brute force `i` to find the max profit.

```
maxProfit(k, m..n) = {
  
  if k == 1 then 
    return call maxProfit1(m..n) // best buy and sell once
  else
    return 
    MAX { 
      for i = 0 .. end
        maxProfit(k - 1, m..i) + maxProfit(1, i..n)
    }
}

```

when `k = 2` 

the func becomes [Best Time to Buy and Sell Stock III](../best-time-to-buy-and-sell-stock-iii)

```
    return MAX { 
      for i = 0 .. end
        maxProfit1(m..i) + maxProfit1(i..n) // m..i is left part and i..n is right part
    }
```

## [Maximum Subarray](../maximum-subarray) like version

I dont like this because I dont think it is easy to understand. 
However, this will reduce the time complexity from `O(n^3)` to `O(n^2)`.

### Start from [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock)

In the [Maximum Subarray](../maximum-subarray),
numbers are always added to the variable `history`. 
when the `history` goes below zero, just drop it.

This is like you and a fool buy and sell stock together,
the fool buys and sells his stocks everyday. 
Whenever the fool earns more money than you at `day i`, 
you could act like fool to get to max profit from `day 0` to `day i`.
otherwise, just keep the max profit.
Sometimes, the fool may go broke, just change another fool.


Talk is cheap, show you the code 

```
public int maxProfit(int[] prices) {
    
    if(prices.length < 1) return 0;

    int[] P = new int[prices.length];  // this is you
    int[] H = new int[prices.length];  // this is that fool
                                       // H is short for history like Maximum Subarray

    for(int i = 1; i < prices.length; i++){
        int p = prices[i] - prices[i - 1];

        H[i] = Math.max(H[i - 1] + p, 0); // buy and sell
                                          // max(H, 0) means when fool goes broke, just start from another

        P[i] = Math.max(H[i], P[i - 1]);  // if the fool earns more than you
                                          // time to act like the fool to get max profit
    }

    return P[prices.length - 1];        
}

```

### Extends to K times

just exntends P and H to 2d. `P[time][day]`


the only difference is change 

```
H[j][i] = Math.max(H[j][i - 1] + p, 0);
```

to

```
H[j][i] = Math.max(H[j][i - 1] + p, P[j - 1][i - 1]);
```

that means the fool should act better than buy and sell `k - 1` times until `day i - 1` (`P[k - 1][i - 1]`),
or the fool should restart from `P[k - 1][i - 1]` in order to get better profit.

```
int[][] P = new int[k + 1][prices.length];
int[][] H = new int[k + 1][prices.length];

for(int j = 1; j <= k; j++) { 

    for (int i = 1; i < prices.length; i++) {
        int p = prices[i] - prices[i - 1];

        H[j][i] = Math.max(H[j][i - 1] + p, P[j - 1][i - 1]);

        P[j][i] = Math.max(H[j][i], P[j][i - 1]);
    }
}
```

## Final cheat

I did some optimization to avoid TLE, 
like caching the difference of `price i` and `price i - 1` into `D`.
but leetcode still reject my code.

I found some test cases is really big, 
but can be got `O(n)` using [Best Time to Buy and Sell Stock II](../best-time-to-buy-and-sell-stock-ii)
because `k > len(prices)`.

