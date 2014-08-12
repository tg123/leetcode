## Recursion 

I solve this prolem in the toilet.

### Review building a BST

```
function buildBST(nodes, root)
  
  root.left  = buildBST(nodes that their vals are less than root.val)
  root.right = buildBST(nodes that their vals are greater than or equal to root.val)
  
```

change to numbers.

```
function numTrees(nodes, root)
  return numTrees(nodes that their vals are less than root.val) * numTrees(nodes that their vals are greater than or equal to root.val)
  
```

that is, there are `numTrees` on `root.left` and `numTrees` on `root.right`, so in sum just `left` times `right`.

### How many roots

Any number can become the root, so just add them up.

```
foreach node in nodes
  sum = sum + numTrees(nodes, node)

```


## Empty tree

let `numTrees(empty tree) = 1`. codes will go well.




