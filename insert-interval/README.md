## Looks like [Merge Intervals](../merge-intervals)

`Merge Intervals` does a sort inside the function, good news for us is that the input is already sorted. 

What we need to do is to [Search Insert Position](../search-insert-position), and insert the new interval there. (Insertion Sort)


Now call `Merge Intervals` without sort.
