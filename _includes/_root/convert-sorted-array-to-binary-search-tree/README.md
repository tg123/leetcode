## Height balanced BST

If `balanced` is not required, we can add all number to the right node one by one.

`BST` and `QuickSort` are good friends. The pivot here is the middle of the input array.

code looks like `QuickSort`, too.

```
function sortedArrayToBST(array)
   
   root = middle of array
   
   root.left  = sortedArrayToBST(number on the root's left)
   root.right = sortedArrayToBST(number on the root's right)


```
