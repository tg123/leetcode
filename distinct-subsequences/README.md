## Guessing

Lets start with `rabbbit` and `rabbit`.

To make the problem easier, start from one char, `distinct subsequences` of `rabbbit` and `r`.

`distinct subsequences` below, by eyeball:

 * `r` and `r` has 1 `distinct subsequences`
 * `a` and `r` has 0 `distinct subsequences`

These two are easy to be understood.

 * `ra` and `r` has 1 `distinct subsequences`
 * `rab` and `r` has 1 `distinct subsequences`
 * `rabbbbbbbbbbbb` and `r` has 1 `distinct subsequences`

These three show that `r` plus any junk chars will not change `distinct subsequences`

 * `rr` and `r` has 2 `distinct subsequences`
 * `rar` and `r` has 2 `distinct subsequences`
 * `rara` and `r` has 2 `distinct subsequences`
 * `rarar` and `r` has 3 `distinct subsequences`

`rar` and `r` is same as `rr` and `r`, because `a` there has nothing to do with the number of `distinct subsequences`, it is a junk like above.

In another word, `rar` and `r` can be converted to `ra` + `r` and `r`, that is `1 + 1`.

### Put them into table

the value `P[i][j]` means that `S[0..i]` and `T[0..j]` has `P[i][j]` `distinct subsequences`.

the table with only one char

```
+---+---+---+---+---+---+---+---+
|   | r | a | b | b | b | i | t |
+---+---+---+---+---+---+---+---+
| r | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
```

Enlarge the table


```
+---+---+---+---+---+---+---+---+
|   | r | a | b | b | b | i | t |
+---+---+---+---+---+---+---+---+
| r | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
| a |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| b |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| b |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
```

Some grids here are easy to be filled, the grids which `j > i`. 
That is, T is longer than S, there will be no `distinct subsequences`.

```
+---+---+---+---+---+---+---+---+
|   | r | a | b | b | b | i | t |
+---+---+---+---+---+---+---+---+
| r | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
| a | 0 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 | 0 |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 0 | 0 | 0 | 0 |   |   |   |
+---+---+---+---+---+---+---+---+
| t | 0 | 0 | 0 | 0 | 0 |   |   |
+---+---+---+---+---+---+---+---+
```

`j == i` grids are easy too, the S and T must be the same if it wants to have 1 `distinct subsequences`.

```
+---+---+---+---+---+---+---+---+
|   | r | a | b | b | b | i | t |
+---+---+---+---+---+---+---+---+
| r | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
| a | 0 | 1 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 | 1 |   |   |   |   |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 | 0 | 1 |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 0 | 0 | 0 | 0 | 0 |   |   |
+---+---+---+---+---+---+---+---+
| t | 0 | 0 | 0 | 0 | 0 | 0 |   |
+---+---+---+---+---+---+---+---+
```

This pictrue is just encouraging you, as there is only a few grids left to be filled.

### `rab` and `ra`

This problem looks familiar. It is the `ra` and `r`.

as `b` is a junk char, `rab` should have the same number as `ra` and `ra`.

Then the table is like

```
+---+---+---+---+---+---+---+---+
|   | r | a | b | b | b | i | t |
+---+---+---+---+---+---+---+---+
| r | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
| a | 0 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 | 1 |   |   |   |   |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 | 0 | 1 |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 0 | 0 | 0 | 0 | 0 |   |   |
+---+---+---+---+---+---+---+---+
| t | 0 | 0 | 0 | 0 | 0 | 0 |   |
+---+---+---+---+---+---+---+---+
```

### `rabb` and `rab`

This time, add a new `b` to both `rab` and `ra`.

#### Use the new `b` in subsequences

This time they have same letter, `b` , at the end. It is not a junk.

This time, remove `b` from both S and T, then they become `rab` and `ra`.

that is, this will take `rab` and `ra` `distinct subsequences`.

#### Dont use the new `b`

Treat `b` as junk, it has `rab` and `rab` `distinct subsequences`.


#### Sum up two choices

Use or not will result two set of `distinct subsequences`, so sum them up.

`rabb` and `rab` = `rab` and `ra` + `rab` and `rab`.

```
+---+---+---+---+---+---+---+---+
|   | r | a | b | b | b | i | t |
+---+---+---+---+---+---+---+---+
| r | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
| a | 0 | 1 | 1 | 1 | 1 | 1 | 1 |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 | 1 | 2 |   |   |   |
+---+---+---+---+---+---+---+---+
| b | 0 | 0 | 0 | 1 |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 0 | 0 | 0 | 0 | 0 |   |   |
+---+---+---+---+---+---+---+---+
| t | 0 | 0 | 0 | 0 | 0 | 0 |   |
+---+---+---+---+---+---+---+---+
```

## General form

the grid `P[i][j]` has 1 choice when `S[i] != T[j]`, this only adds some junk chars.

```
P[i][j] = P[i - 1][j] 
```

the grid `P[i][j]` has 2 choice when `S[i] == T[j]`

```
P[i][j] = 
P[i - 1][j] // adds as junk chars.
+
P[i - 1][j - 1] // use the new char in the new subsequence

```

Fill up the table and the bottom right grid is the answer.


