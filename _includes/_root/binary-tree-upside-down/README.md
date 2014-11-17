## $ 15

This is the first paid problem ever. `Nov 17`

## Inorder travel

I found it just looks like result of an inorder travel on the tree

```
    1
   / \
  2   3
 / \
4   5
```

Inorder: 4 2 5 1 3

Result:

```
   4
  / \
 5   2
    / \
   3   1  
```

we can build the new tree using the inorder result easily.

### Difference from regular inorder travel

 * No need to inorder right child, because it must be leaf or empty
 * Empty right child should be added to the result if left child is not empty. This is to recovery the empty node in the new tree.



