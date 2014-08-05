## [Unique Paths](../unique-paths) with obstacle

`1 * n` matrix

there will be `0` unique path on the left side of an obstacle.

```
+---+---+---+---+---+---+---+
| 1 | 1 | 1 | B | 0 | 0 | 0 |
+---+---+---+---+---+---+---+
```

obstacle blocks the path to girds on its bottom or left.

```
+---+---+---+---+---+---+---+
| 1 | 1 | 1 | B | 0 | 0 | 0 |
+---+---+---+---+---+---+---+
| 1 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   |   | B |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   | n | x |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| 1 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+

```

in this case, `gird x` has only n paths from left grid.


Generally, `[x][y] = ([x - 1][y] or 0 if blocked) + ([x][y - 1] or 0 if blocked)`

