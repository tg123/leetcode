## Merge each two

If you can [Merge Two Sorted Lists](../merge-two-sorted-lists), then you can merge k by merging each two using a stack.

code 

```
put lists into a stack

while stack has more than 2 lists
   
   merged = mergeTwoLists(stack.pop(), stack.pop())
   
   stack.push(merged)

```

Leetcode accpected the code above at Oct 2013. 
But, the code got a `Time Limit Exceeded` when I change `ArrayList` to `List`. (`ArrayList` is used on old version leetcode)


## Reduce the time complexity to O(nlgn)

`O(nlgn)` reminds me that something is call `MergeSort`. So just write code like a `MergeSort`.


```
functino mergeKLists(lists)
  left  = mergeKLists(k / 2 lists)
  right = mergeKLists(k / 2 lists)

  return merge(left, right)

```
