## Guessing 


`1 * 1` matrix have `1` unique path

```
+---+
| 1 |
+---+
```

`1 * 2` matrix have `1` unique path

```
+---+---+
| 1 | 1 |
+---+---+
```


`1 * n` or `n * 1` matrix have `1` unique path

```
+---+---+---------
| 1 | 1 |   -->
+---+---+---------
```

`2 * 2` matrix have `2` unique paths


```
+---+---+
| 1 | 1 |
+---+---+
| 1 | 2 |
+---+---+

+-----+
|     |
|     v
+--->

```

a grid can only be entered from the grid on its top or left.


## Grid x

```
+---+---+---+---+---+---+---+
| 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+
| 1 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   |   | m |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   | n | x |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+

```

Assume that

 * from top-left to `grid m`, there are `m` unique paths
 * from top-left to `grid n`, there are `n` unique paths

So that

 * there is `m` unique paths from top-left to `grid x` via  `grid m`
 * there is `n` unique paths from top-left to `grid x` via  `grid n`

 * there is `m + n` unique paths from top-left to `grid x` via `grid m` and `grid n`


## Fill up the matrix

we can build a matrix that

 * all `[0][?] = 1`
 * all `[?][0] = 1`

fill up grids in the matrix one by one `[x][y] = [x - 1][y] + [x][y - 1]`


the value in the bottom-right grid is how many paths from top-left to bottom-right.
