## [Word Break](../word-break) with traceback

In order to output all solutions, 
just change P from `boolean` to a collection which contains all parent index.


```
 0 1 2 3 4 5 6 7 8 9 A
 * c a t s a n d d o g
 
       0 0     3     7
               4


P[3] = [0]
P[4] = [0]

P[7] = [3, 4]
P[10] = [7]

```

## Recover strings using DFS

To find all strings break at breakpoint, just using DFS to find out them.

 * 10, 7, 3, 0: dog sand cat
 * 10, 7, 4, 0: dog and cats

### Note:

offsets here is 1 larger than the original offset.

So, `7..10` here is to start form the next element, the 8th to the 11th(exclusive).

Luckily, restore the `S[8th..11th]` is just the same as `S[7..10]`,
Because index of S starts from `0`.


