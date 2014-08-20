## First glance

It would be an easy problem if [Binary Tree Level Order Traversal](../binary-tree-level-order-traversal) works. 
Yet, a queue is not allow because of that constant space is required.

## Recursion

connecting left and right child is easy, just `node.left.next = node.right`


Before 

```
        1
       /  \
      2    3
     / \  / \
    4  5  6  7
```


After 

```
        1
       /  \
      2 -> 3
     / \  / \
    4-> 5 6->7
```

`5` and `6` shoud be connected。

when connecting `4` and `5`, `2` and `3` is already connected, that is a good news, we can connect `5` and `6` using `2.next`.

```
node.right.next = node.next.left;
```
