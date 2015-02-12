## Core tech of MergeSort

Merge is the core technology of MergeSort, that is why it was named MergeSort.

```

convert input array -> left_part and right_part

left_sorted_part  = MergeSort(left_part)
right_sorted_part = MergeSort(right_part)

Merge(left_sorted_part, right_sorted_part)

```

## Merging

 1. set `t` the end of `result array`
 1. taking one (`l`) from the end of `left_sorted_part`
 1. taking one (`r`) from the end of `right_sorted_part`
 1. find the larger(`g`) one in `l` and `r` 
 1. put `g` at position `t` of `result array`
 1. loop until `t` reach the bottom of `result array`

When `result array` is an empty array,
it is passable to copy from the beginning of `left_sorted_part` and `right_sorted_part`.

In this problem, however, we have to copy from end to beginning due to that `left_sorted_part` and `result array` are sharing the same array.
