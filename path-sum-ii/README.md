## Definition

Similar to [Sum Root to Leaf Numbers](../sum-root-to-leaf-numbers)


```
pathSum(node) = []                                                    [ empty tree   ]
                parent_list(node) union node.val                      [ node is leaf ]
                pathSum(node.left) unoin pathSum(node.right)          [ otherwise    ]
           
parent_list(node) = []                                                [ node is root ]
                    parent_list(parent_node) union parent_node.val    [ otherwise    ]
```



