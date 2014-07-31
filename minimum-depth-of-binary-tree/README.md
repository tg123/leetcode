## Oppsite to [Maximum Depth of Binary Tree](../maximum-depth-of-binary-tree)

Definition is a litte more complex than `maxDepth`

```
minDepth = 0                                                    [empty tree               ]
           1                                                    [root is leaf             ]
           minDepth(root.left)  + 1                             [root has only left child ]
           minDepth(root.right) + 1                             [root has only right child]
           MIN(minDepth(root.left), minDepth(root.right)) + 1   [otherwise                ]
```

