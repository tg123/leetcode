## O(n) time and O(n) space

if we can use a set, we can put all the input numbers into the set.
and test from 1 to INFINITY, the answer is the first number which is not is the set.


```
set: convert the input array into a set

foreach i in 1 .. infinity

    if i is not in set
        i is the result

```


## O(1) space

if we can reuse the input array as the set, we make it O(1)

a tricky array based set may be like:

```
[1, 1, 0, 1, 1, 0, 1]
 1  2  3  4  5  6  7     [index starts from 1]
```

from the tricky set, we can see the first missing positive number is `3`

### Building the set

```
[1, 2, 0]
[1, 1, 0]       [set]
 1  2  3        [index starts from 1]

[3, 4, -1, 1]
[1, 0,  1, 1]   [set]
 1  2   3  4    [index starts from 1]
```

if we can move number in the input set to the `index` position,
we can check if a number in the set by `number == index`

```
[1, 2, 0]
[1, 2, 0]       [converted array]
 1  2  3        [index starts from 1]

[3, 4, -1, 1]
[1, -1, 3, 4]   [converted array]
 1  2   3  4    [index starts from 1]
```

We can build this kind of set by moving the number to the right position.
If number is not a positive number, just leave it there, it may be exchanged in the further.

#### Building process


```
[3, 4, -1, 1]
 1  2   3  4    [index starts from 1]

 i
```

 * `3` should be at `index 3`, swap `index i` and `index 3`

```
[-1, 4, 3, 1]
  1  2  3  4    [index starts from 1]

  i
```

 * `-1` should not be in the set, ignore and `i` move to next

```
[-1, 4, 3, 1]
  1  2  3  4    [index starts from 1]

     i
```

 * `4` should be at `index 4`, swap `index i` and `index 4`

```
[-1, 1, 3, 4]
  1  2  3  4    [index starts from 1]

     i
```

 * `1` should be at `index 1`, swap `index i` and `index 1`

```
[1, -1, 3, 4]
 1   2  3  4    [index starts from 1]

     i
```

 * `-1` should not be in the set, ignore and `i` move to next


```
[1, -1, 3, 4]
 1   2  3  4    [index starts from 1]

        i
```

 * `3` is already at the right position, move `i` to next

```
[1, -1, 3, 4]
 1   2  3  4    [index starts from 1]

           i
```

 * `4` is already at the right position, move `i` to next


we can know 2 is the first missing positive number, because `2 != -1`.


### Bucket Sort

This set build process, sometime, is known as Bucket Sort.
In this case we use the input array as the bucket.
