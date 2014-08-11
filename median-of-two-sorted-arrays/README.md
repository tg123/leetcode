## Something must know about [Median](http://en.wikipedia.org/wiki/Median)

 * odd: median of {3, 3, 5, 9, 11} is 5
 * even: the median of {3, 5, 7, 9} is (5 + 7) / 2 = 6


## Kth of two sorted array in `O(log(m + n))`

### `O(m + n)` 

Acting like [Merge Sorted Array](../merge-sorted-array), just take first `k` elements.


But, I will show you a brute force version, because it can be optimized to `O(log(m + n))` easily.


### `O(m + n)` Brute Force 

search through kth of `Array M` and `Array N`

Code is like 


```
foreach n in array m and array n
  
  if isKth(n)
    found

```

Core tech is how to determine if `n` is the kth.

#### isKth

Imagine that take `k` elements from `Array M` and  `Array N`, `m` elements from `Array M` and `n` from `Array N`. 

such that, the `Kth` element must be `MAX(mth of Array M, nth of Array N)`

e.g.

```
Array M [1, 3, 5, 7, 9]
Array N [0, 2, 4, 6, 8]


Array M [1,  3,  5,  7,  9]
                   ^       
                   |       
                   +-+     
                     |     
Array N [0,  2,  4,  6,  8]


try to put the nth element after the mth element

```

 * take 3 elements from M: `[1, 3, 5]`
 * take 4(7-3) elements from N: `[0, 2, 4, 6]`
 * the 7th element is: `MAX(5,6)`
 * 8th..10th `[7, 8, 9]` are greater than or equals to the 7th

that is

 * k = m + n
 * kth = MAX(ArrayM[m], ArrayN[n])
 * elements in `ArrayM[m + 1..end]` and `ArrayN[n + 1..end]` must be greater than or equals to the kth


So checking kth code is like

```
function isKth(m, ArrayM, ArrayN)
  n = k - m
  
  return ArrayN[n] <= ArrayM[m] <= ArrayN[n + 1]

```

### `O(log(m + n))` Binary Search

with `isKth`, we can write a binary search version using binary search template.


```

search arrayM

while s < e
   
   m = (s + e) / 2
   
   if iskth(m, arrayM, arrayN)
     return ArrayM[mid]
   
  
   // solve this later
   s = m + 1 or e = m
   
```

this will take `O(log(m))` time, if kth is not found, do the same to `ArrayN`.

#### `s = m + 1 or e = m`

when mid is not kth, we are going to remove half of the elements that must not contain the kth.


```
searching Array M

Array M [0, 2, 4, 6, 8]
         s     m     e 

Array N [1, 3, 5, 7, 9]
                  n
k = 7
n = k - m
```

 * ArrayM[m] = 4
 * ArrayN[n] = 7

If `ArrayM[m]` is not the kth, that is, `ArrayM[m]` is less than `ArrayN[n]` or `ArrayN[n + 1]`.

When `ArrayM[m] < ArrayM[n]`, we must enlarge the `ArrayM[m]`, so `s = m + 1` if we want `ArrayM[m]` to be the kth.

Similarly, we must diminish ArrayM[m] if `ArrayM[m] > ArrayM[n]`

In code:

```
if ArrayM[m] < ArrayM[n]
  // enlarge ArrayM[m]
  s = m + 1
else
 // diminish ArrayM[m]
  e = m
```

## Put them together

```

len = len(A) + len(B)

if len is odd
  kth(A,B, len/2)
else
  (kth(A,B, len/2) + kth(A,B, len/2 + 1)) / 2


```

## Note

 * Array in my code start from  `0`
 * Sometimes, no element on any index, just treat it as -INFINITE
