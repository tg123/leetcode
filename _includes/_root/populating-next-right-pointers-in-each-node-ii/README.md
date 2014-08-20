## Improved version of [Populating Next Right Pointers in Each Node](../populating-next-right-pointers-in-each-node)

This time, finding next is a bit difficult.
`node.right.next = node.next.left` is no longer working.

But parent's next is also useful, and only need to seach a little more nodes.

```
    1
   /  \
  2    3
   \    \
    4    5
   /    / \
  6    7   8
```

 * `6.next` = `7` = `5.left`  = `4.next.left`
 * `4.next` = `5` = `3.right` = `2.next.right`

Searching path is like

 * node's parent's left
 * node's parent's right
 * take node's parent's next as parent and search again


Note:

`connect(right)` before `connect(left)`, because `left nodes` depend on `right nodes' next`
