## Yet Another [Unique Paths](../unique-paths)

put the strings onto the matrix



```
+---+---+---+---+---+---+---+
|   | * | a | a | b | c | c |
+---+---+---+---+---+---+---+
| * |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| d |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| b |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| b |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| c |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| a |   |   |   |   |   |   |
+---+---+---+---+---+---+---+

```

Paths for `aadbbcbcac`, from top-left ot bottom-right. each step can choose to go to the grid on the right or the grid on the bottom.
 
 * from `1,1` goto `1,2` use letter `a` in `aabcc`
 * from `1,2` goto `1,3` use letter `a` in `aabcc`
 * from `1,3` goto `2,3` use letter `d` in `dbbca`
 * fork from `2,3`, the next step can be `2,4` or `3,3`
 * ... 
 * until no next step or reach the bottom right grid.


```
+---+---+---+---+---+---+---+
|   | * | a | a | b | c | c |  0
+---+---+---+---+---+---+---+
| * | 1 | 1 | 1 |   |   |   |  1
+---+---+---+---+---+---+---+
| d |   |   | 1 | 1 |   |   |  2
+---+---+---+---+---+---+---+
| b |   |   | 2 | 1 | 1 |   |  3
+---+---+---+---+---+---+---+
| b |   |   | 2 |   | 1 |   |  4
+---+---+---+---+---+---+---+
| c |   |   | 2 | 2 |1 2|   |  5
+---+---+---+---+---+---+---+
| a |   |   |   |   |1 2|1 2|  6
+---+---+---+---+---+---+---+
  0   1   2   3   4   5   6

```

Paths for `aadbbbaccc`


```
+---+---+---+---+---+---+---+
|   | * | a | a | b | c | c |
+---+---+---+---+---+---+---+
| * | 1 | 1 | 1 |   |   |   |
+---+---+---+---+---+---+---+
| d |   |   | 1 | 1 |   |   |
+---+---+---+---+---+---+---+
| b |   |   | 2 | 1 |   |   |
+---+---+---+---+---+---+---+
| b |   |   | 2 | 1 |   |   |
+---+---+---+---+---+---+---+
| c |   |   |   |   |   |   |
+---+---+---+---+---+---+---+
| a |   |   |   |   |   |   |
+---+---+---+---+---+---+---+

```

No path can reach the bottom right grid.

## [Dynamic programming](http://en.wikipedia.org/wiki/Dynamic_programming)

`P[i][j]` indicates that there is an `Interleaving String` formed by `S1[0..i - 1]` and `S2[0..j - 1]`.

 * `P[1][1]` = true
 * `P[i][j]  = (P[i - 1][j] || P[i][j - 1]) && (S3[i + j - 1] == S1[i - 1] || S3[i + j - 1] == S2[j - 1])`


I think Dynamic programming is brain fucking. Not as easy as the girds, but, essentially, they are the same.

