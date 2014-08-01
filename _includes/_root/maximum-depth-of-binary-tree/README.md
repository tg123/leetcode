## Definition 

```
maxDepth = 0                                                    [if root is null]
           MAX(maxDepth(root.left), maxDepth(root.right)) + 1   [otherwise      ]
```
