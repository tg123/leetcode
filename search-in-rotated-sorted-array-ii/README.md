## By [accident](http://en.wikipedia.org/wiki/Programming_by_permutation) Again

using programming by accient we solved [Search in Rotated Sorted Array](../search-in-rotated-sorted-array).

But, this time, We can t sure the target number is on the left or on the right of the `mid`.

e.g.

```
t = 2

[ 1 1 1 1 1 1 2 1 1 1 1]
  s         m         e    
```

this time, we do not know `s = m + 1` or `e = m`.

### Brute force again

`s` `m` `e` may be like below. (put == or != between `s` `m` `e`)

   * `s` != `m` != `e`
   * `s` != `m` == `e`
   * `s` == `m` != `e`
   * `s` == `m` == `e`
 

`s` != `m` != `e`

this is handled by [Search in Rotated Sorted Array](../search-in-rotated-sorted-array).


`s` != `m` == `e`

```
[ 1 1 1 1 2 2 2 2 2 2 2]
  s         m         e    
```

`m` == `e` means `m` .. `e` are the same number. they are safe to be removed. 
Remember, number at `m` does not equal to `t`, because we had checked `if A[m] == t` before.


`s` == `m` != `e`

```
[ 1 1 1 1 1 1 1 2 2 2 2]
  s         m         e    
```

this case is the same as `s` != `m` == `e`


`s` == `m` == `e`

Wrost case

```
t = 2

[ 1 1 1 1 1 1 2 1 1 1 1]
  s         m         e    
```

we only know `t` does not equal to `s` `m` or `e`.

what we can do it only search again by doing

```
s = s + 1
e = e - 1
```

