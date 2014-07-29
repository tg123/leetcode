## Normal binary seach

just reciting a binary search code

```

while s < e
  
  mid = (s + e) / 2
  
  if target == A[mid]
    return mid
  else if target < A[mid]
    e = mid
  else if target > A[mid]
    s = mid + 1


```

## Binary search essential 

Each time we separate the numbers into two parts. 
After the target number compared to the mid number, we are sure which part that the target number must be in.


## Which part the target must be

In this case, there is no duplicate, so the target must be either in left part or right part.

What we need to do is to determine which part.

```

while s < e
  
  mid = (s + e) / 2
  
  if target == A[mid]
    return mid
  else if on the left
    e = mid
  else if on the right
    s = mid + 1


```

### Brute force

Dont be brainfucked. so just write down all possible `s`,`m`,`e` and `t`.

`t` is either on the left side or right side of `m`.

```
[s  t  m    e]

or

[s     m t  e]
```

and `s` `m` `e` may be like below. (put `<` or `>` between `s` `m` `e`)
  
 * `s` < `m` < `e`
 * `s` < `m` > `e`
 * `s` > `m` < `e`
 * `s` > `m` > `e`


`s` < `m` < `e`  (normal binary search)


```
  1                   E
  2                 *
  3               *
  4             *
  5           *
  6         M
  7       *
  8     *
  9   *
 10 S
```

`s` < `m` > `e`


```
  1              *
  2            *
  3          M
  4        *
  5      *
  6    *
  7  S
  8                    E
  9                  *
 10                *
```

`s` > `m` < `e`

```
  1      *
  2    *
  3  S
  4                     E
  5                   *
  6                 *
  7               *
  8             M
  9           *
 10         *
```

`s` > `m` > `e` 

this is not a sorted array


#### After got all the possible cases

2 (`t` either on the left or on the right of `m` ) * 3 ( relations of `s` `m` `t` ) = 6 cases

each case choose either the left part(`e = m`) or the right part(`s = m + 1`) of input array.


You can determine which part to choose by your brain or by [accident](http://en.wikipedia.org/wiki/Programming_by_permutation). 

Dont worry, if you choose part by accident, it is at most 64 tries. 







