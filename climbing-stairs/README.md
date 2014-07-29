## Recursion
  
  * 0 stair  has  0 way
  * 1 stair  has  1 way
  * 2 stairs have 2 ways (0->1->2, 0->2)
  * 3 stairs have 3 ways (0->1->2->3, 0->2->3, 0-1->3)
  * ...

stair `3` come be jump from stair `1`(1 ways from 0 to here) and stair `2`(2 ways from 0 to here).

so...

```
climbStairs(n) = climbStairs(n - 1) + climbStairs(n - 2)
```
  
## [Space-time tradeoff](http://en.wikipedia.org/wiki/Space%E2%80%93time_tradeoff)

put stair `i` into cache.
