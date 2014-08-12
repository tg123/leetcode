## What will the maximum path look like

Though paths can be starting from any node and end at any node, the appearances only can be:

 * Appearance 1

```
      *
     / \
    *   *
   /     \ 
  *       *
 /         \ 
S           *
             \
              E
```

 * Appearance 2

```
      E
     / 
    * 
   / 
  * 
 / 
S           
```

* Appearance 3

```
S
 \
  *
   \
    *
     \
      *
       \
        E         
```

### Note

Appearances above are only talking about `TRUNK`.

Treat the path below as Appearance 1

```
      *
     / \
    *   *
   /     \
  *       *
   \     /
    S   *
         \
          E
```


## Tree Version of [Maximum Subarray](../maximum-subarray)

 * Appearance 2/3

These two appearances are easy to understand and to build a path, just take the maximum node. 
like `Maximum Subarray`, if the sum goes below `0`, forget the old nodes.

 * Appearance 1

If a node's left child or right child is less than `0`, drop it, then the node becomes `Appearance 2/3`.
 
If both the left child and right child are positive, just add them together, `maxPathSum(node.left) + node.val + maxPathSum(node.right)` will be the `maxPathSum` which contains that node.


## Put them together

As we know how to find the `maxPathSum` of any node, we can go through the tree and update the max value.



