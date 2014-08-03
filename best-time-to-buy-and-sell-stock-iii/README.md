## [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock) Twice


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

If prices are divide into two parts at position `i`, we can treat each part as a `0..i` [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock) and `i..end` [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock).


## Brute force `i`

As we do not know which `i` will be the most profit one, just try test `i` and save them.


```
left  : array 
right : array 

foreach i in prices
   
   left[i]  = Best Time to Buy and Sell Stock 0..i
   right[i] = Best Time to Buy and Sell Stock i..end

```

maxProfit is MAX(`left[i] + right[i]`)
