## Recursion

take two nodes from the linked list,
if the first's `val` equals to the , we can sure that the first node is unique.
just append `deleteDuplicates(second)` to the first one.


if they equals to each other, we can sure that they should be removed.
search through the linked list, remove all nodes until a different one is appeared.
