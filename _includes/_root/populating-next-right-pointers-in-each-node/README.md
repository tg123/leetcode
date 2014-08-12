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
