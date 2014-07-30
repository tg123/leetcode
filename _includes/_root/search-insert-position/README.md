## The core tech of InsertionSort
 
a InsertionSort is like


```
sorted is an array to store sorted values

foreach value in input

   p = search_insert_position(sorted_array, value)
   
   insert value at p in the sorted_array

```


## Where to insert

The sorted array is in non-descending order. The first A[i] greater than or equals to the `value` is where to insert the `value`.
