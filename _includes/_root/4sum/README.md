## [Space-time tradeoff](http://en.wikipedia.org/wiki/Space%E2%80%93time_tradeoff)

Brute force will solve this problem, but leetcode will reject because of time limit.

## [Two Sum](../two-sum) + [Two Sum](../two-sum) = 4 Sum

  * build two number's sum cache `{ 42 : [index1, index2], ...  }`
  * foreach `key` in cache and `sum - key` in cache, add the cartesian product of the values to the result collection
