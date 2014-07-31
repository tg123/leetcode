## Recursion 

 * `0 swaping` an empty linked list yields empty linked list
 * `1 swaping` an one-node linked list yields one-node linked list itslef.
 * `2 swaping` a two-nodes linked list yields a linked list with the original list head and tail swapped.

So ..

 * `n swaping` a n-nodes linked list is to concat(swaping(2), swaping(n - 2))
