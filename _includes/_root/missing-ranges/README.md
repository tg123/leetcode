## Loop invariant

init range is lower -> upper

when a new number comes, the number divide the range into two ranges. 
the left range must be a missing range. just output it.


```
R = [0 -> 99]
S = [0, 1, 3, 50, 75]
     ^
     |
```

`0` divide `[0 -> 99]` into `empty range` and `[1 -> 99]`

```
R = [1 -> 99]
S = [1, 3, 50, 75]
     ^
     |
```

`1` divide `[1 -> 99]` into `empty range` and `[2 -> 99]`

```
R = [2 -> 99]
S = [3, 50, 75]
     ^
     |
```

`3` divide `[2 -> 99]` into `[2]` and `[4 -> 99]`

`[2]` is a missing, output.


```
R = [4 -> 99]
S = [50, 75]
     ^
     |
```

`50` divide `[4 -> 99]` into `[4 -> 49]` and `[51 -> 99]`

`[4 -> 49]` is a missing, output.


```
R = [51 -> 99]
S = [75]
     ^
     |
```

`75` divide `[51 -> 99]` into `[51 -> 74]` and `[76 -> 99]`

`[51 -> 74]` is a missing, output.


the last one `[76 -> 99]` is a missing range too.
