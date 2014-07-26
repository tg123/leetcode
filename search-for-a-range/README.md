## Improved binary search 

There is no guarantee which one will be found when using a binary search and the input array has many same elements.

What we need to do is after we got the index, search the left and right to expand the range.


```

if found
   
   left  = index
   right = index
   
   expand left  while A[left]  == target
   expand right while A[right] == target


```
