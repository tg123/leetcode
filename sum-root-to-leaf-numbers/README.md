## Definition

```
sumNumbers(node) = 0                                                  [ empty tree   ]
                   parent_val(node) + node.val                        [ node is leaf ]
                   sumNumbers(node.left) + sumNumbers(node.right)     [ otherwise    ]
           
parent_val(node) = 0                                                  [ node is root ]
                   parent_val(parent_node) + parent_node.val          [ otherwise    ]
```


I have written some versions using DFS and BFS, but they are not as clear as above.
