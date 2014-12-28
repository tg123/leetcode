## `O(n)` Sort

The problem requires `O(n)` time complexity, and it looks something like sort. 
[Bucket Sort](http://en.wikipedia.org/wiki/Bucket_sort) and [Radix sort](http://en.wikipedia.org/wiki/Radix_sort) 
are the two well known `O(n)` sort.

Maybe an `O(32n)` radix sort will work well.

## Bucket sort version

> First, I choose N buckets and divide nums into [0, avg) [avg, 2avg) .... [navg, inf) and do a regular bucket sort.
Through, this solution got accepted by leetcode, I found there is a better solution.

the most ideal gap is `max - min`. so if there is `N` elements, there will be `N - 1` gaps, 
the `maximum gap` must be greater than `(max - min) / (N - 1)`.

Like bucket sort, we put nums into  `(max - min) / (max_gap) + 1` buckets, 
but, this time a good news is that we do not need to sort the numbers in the buckets,
what we need is only to remember the max and min of the bucket.
The reason is easy to understand: the number between the max and min of the bucket will not yield a bigger gap.

after bucketing, numbers are like

```
[MIN]   [MIN]          [MIN]
[   ]   [   ]    ...   [   ]
[MAX]   [MAX]          [MAX]
```

The work left is to measure the gap between `bucket[i - 1].max` and `bucket[i].min`.

Note: the will be some emtpy buckets, skip them.
