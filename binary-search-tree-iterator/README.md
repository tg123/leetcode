## [Yielding](http://en.wikipedia.org/wiki/Generator_(computer_programming)) and [Binary Tree Inorder Traversal](../binary-tree-inorder-traversal)

In the problem [Binary Tree Inorder Traversal](../binary-tree-inorder-traversal),
we solved it by simlating the function call.

Only a bit different this time, 
when the caller calls `next()`: 

 1. just execute to next value returns
 1. save the stack and next address (state)
 1. yield the node value and return control to caller
 
actions above is the `while` body part in the [Binary Tree Inorder Traversal](../binary-tree-inorder-traversal).

### Edge cases in `hasNext()`

like [Binary Tree Inorder Traversal](../binary-tree-inorder-traversal),
when the stack is empty, there are no more nodes.

However, if only one state left in the stack and the address of the state is `POST`,
we need some additional check.

`POST` state here means to deal with right node of current node (value already yeild to caller when `IN` step).
sometimes, the node does not have right child. we should return false when caller ask `hasNext()`.

## Why it is `O(h)` in space

the space here used in my solution is the `stack`.
only tree nodes with left child will consume a space in the `stack`.
because nodes without left child can be yield to caller directly.

Worst case

```
     1
    /
   2
  /
 3  
```

here we have to save `node 1` and `node 2` before we found `node 3`.
but the space used in stack will be no more than 3.
