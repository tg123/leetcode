## Picking up numbers on [Unique Paths](../unique-paths)

From top left to the right bottom there is `n` [Unique Paths](../unique-paths).

Picking up the numbers alone each path and sum them, we can collect all `Path Sum`.


e.g. a matrix with numbers


```
+---+---+
| 1 | 3 |
+---+---+
| 2 | x |
+---+---+
```


`grid x` has `2` unique paths and `2` `path sum`s
  
  * 1 + 3 + x
  * 1 + 2 + x (minimum)

There are `2` viable paths to `grid x`, the grid on the left side of `grid x` and the grid on top of `grid x`.
We can choose the smaller path sum viable one, that will minimize path sum to `grid x`.


## Grid x

```
+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
|   |   |   | m |   |   |   |
+---+---+---+---+---+---+---+
|   |   | n | x |   |   |   |
+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
```

Assume that

 * `grid m` has a minimum path sum `m`
 * `grid n` has a minimum path sum `n`

So

the minimum path sum `grid x` is MIN(m, n) + x

## Fill up the matrix


Generally, `P[x][y]` is minimum path sum from top left.

 * `P[x][y] = MIN(P[x - 1][y], P[x][y - 1]) + grid[x][y]`

the overall answer is in the right bottom grid.

such filling up process is well know as [Dynamic programming](http://en.wikipedia.org/wiki/Dynamic_programming)
