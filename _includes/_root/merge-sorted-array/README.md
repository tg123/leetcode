## Core tech of MergeSort

Merge is the core technology of MergeSort, that is why it was named MergeSort.

```

convert input array -> left_part and right_part

left_sorted_part  = MergeSort(left_part)
right_sorted_part = MergeSort(right_part)

Merge(left_sorted_part, right_sorted_part)

```

## Merging

 1. taking one (`l`) from `left_sorted_part`
 1. taking one (`r`) from `right_sorted_part`
 1. find the smaller(`s`) one in `l` and `r` 
 1. put `s` into `result array`
 1. put bigger one back to `left_sorted_part` or `right_sorted_part`
 1. loop to step 1 until one is empty
