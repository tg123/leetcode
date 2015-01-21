## Knight on the [Unique Paths II](../unique-paths-ii)

Same problem as [Unique Paths II](../unique-paths-ii). Only different is to walk from end to start.


The Dungeon

```
+-----+-----+-----+
| -2  | -3  |  3  |  A
+-----+-----+-----+
| -5  | -10 |  1  |  B
+-----+-----+-----+
| 10  | 30  | -5  |  C
+-----+-----+-----+

   1     2     3
```

### The minimum health when the Knight reach the final Boss

Let make a table.

final room need `1 - (-5) = 6` HP (`hp - 5 = 1` to survive)

```
+-----+-----+-----+
|     |     |     |  A
+-----+-----+-----+
|     |     |     |  B
+-----+-----+-----+
|     |     |  6  |  C
+-----+-----+-----+

   1     2     3
```

the Knight can enter the final room from either `C2` or `B3`.

in `C2` he can got `30` HP, so if he could reach `C2` then he can enter the final room. So he only need to survive (`1 HP`).
`1 + 30 > 6`.

in `B3` he will get `1` HP. the Knight will need `5 (6 - 1)` HP to reach the final room.

```
+-----+-----+-----+ 
|     |     |     |  A
+-----+-----+-----+
|     |     |  5  |  B
+-----+-----+-----+
|     |  1  |  6  |  C
+-----+-----+-----+

   1     2     3
```

in `B2`, the Knigth need `11 (1 - (-10))` HP to reach `C2` and `15 (5 - (-10)) to reach `B3`.

If I were the Knight i would enter `C2` because it requires less HP. `B2 = MIN(11, 15)`

```
+-----+-----+-----+ 
|     |     |     |  A
+-----+-----+-----+
|     | 11  |  5  |  B
+-----+-----+-----+
|     |  1  |  6  |  C
+-----+-----+-----+

   1     2     3
```


In gerneral, HPNeed[x][y] = MIN(HPNeed[x + 1][y] - D[x][y], HPNeed[x][y + 1] - D[x][y]). 

Sometimes, the HPNeed[x][y] might go below zero, like `C2` <- `C3`, that means `1 HP` is OK.

The work is to fill up the table, and the first cell is the answer.

```
+-----+-----+-----+ 
|  7  |  5  |  2  |  A
+-----+-----+-----+
|  6  | 11  |  5  |  B
+-----+-----+-----+
|  1  |  1  |  6  |  C
+-----+-----+-----+

   1     2     3
```
