## Recursion

```
Pre-order: F, B, A, D, C, E, G, I, H
           p
 
In-order:  A, B, C, D, E, F, G, H, I
                          q

```

From first char `F` in `Pre-order`, we are sure that the root of the tree is `F`.

and from `In-order`, `F` divide the tree into two parts, the left one is  `A, B, C, D, E`, the right one is `G, H, I`.

```
               F
             /   \
A, B, C, D, E     G, H, I

```

`A, B, C, D, E` and `B, A, D, C, E` become a new `buildTree` problem. so we can build the tree recursively. 
the result tree is the left children of `F`.


Similarly, `G, H, I` and `G, I, H` become the right children of `F`.
