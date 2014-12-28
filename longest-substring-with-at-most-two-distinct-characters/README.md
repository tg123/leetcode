## Relative of [Minimum Window Substring](../minimum-window-substring)

This problem is a litte easier than [Minimum Window Substring](../minimum-window-substring).

## Loop invariant 

Assume that `S` is a `string with at most two distinct char`

when a new char `c` comes: 
 * append it to `S`'s right
 * trim from `S`'s left, remove one char until `S` is a `string with at most two distinct char`

```
S = 'aabb'

new char c = 'c'

S = 'aabbc'

S is not `string with at most two distinct char`
so remove a from S

S = 'abbc'

S is not `string with at most two distinct char`
so remove a from S

S = 'bbc'

```


## Finding max

after each loop, `S` is a `string with at most two distinct char`. but, its length changes.
what we need is to find the max length.
