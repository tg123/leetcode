## Variant of [Search in Rotated Sorted Array](../search-in-rotated-sorted-array)


### The 3 cases in a `Rotated Sorted Array` when using binary search

 * `s` < `m` < `e` : `min = num[s]` 



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

 * `s` < `m` > `e` : min must in `m .. e`


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

 * `s` > `m` < `e` min must in `s .. m + 1`


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

Now, Loop until `s` < `m` < `e`
