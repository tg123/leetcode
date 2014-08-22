## [Space-time tradeoff](http://en.wikipedia.org/wiki/Space%E2%80%93time_tradeoff)

A brute force solution is easy. Yet, obviously, time limited. 

### Check concatenation using count sum

cut a string `S` into N substring, lets say `s1 * 1, s2 * 2, s3 * 1`, 
that is, `S` could be `s2s1s2s3` or `s3s1s2s2` or some string else.

convert `L` to count sum, which is a map of `string to count`

```
M = empty Map

for s in L
  M[s] = M[s] + 1
  

```


check concatenation S by minus count

```
cut S into substrings by some length

_M = clone of M

for s in substrings
  
  if _M[s] == 0
    Not a concatenation
 
  _M[s] = _M[s] - 1
  


```
