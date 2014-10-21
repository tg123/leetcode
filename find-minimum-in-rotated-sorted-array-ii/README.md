## Merge [Find Minimum in Rotated Sorted Array](../find-minimum-in-rotated-sorted-array) and [Search in Rotated Sorted Array II](../search-in-rotated-sorted-array-ii)

Patch to [Find Minimum in Rotated Sorted Array](../find-minimum-in-rotated-sorted-array) is
to handle the worst case

```
[ 1 1 1 1 1 1 2 1 1 1 1]
  s         m         e    
```

when `s = m = e` we do not know which part contains the mininum number.
we have to do it in brute force: 

```
min(num[s], findmin(num[s + 1 .. e]))
```
