## Sub tasks

reorder can be achieved via

  1. cut from the middle into left and right
  1. reverse the right part
  1. join the linked list

## Some O(n) method to deal with a linked list

### Reverse a linked list

  1. walk through the linked list
  1. set `node.next` to `prev`
  1. store `current node` the `prev`
  1. loop

the initialization of `prev` is the tail `NULL`

### Finding the middle of a linked list

fast-slow pointer.

  1. fast runner goes 2 steps each time
  1. slow runner goes 1 step
  1. when fast reach the end of the linked list, the slow id the middle of the list


