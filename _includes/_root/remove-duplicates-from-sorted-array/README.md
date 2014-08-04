## Loop invariant

If there is `n` joint of different number in the array (`A[i] != A[i - 1]``),
the length of the final array without duplicates should be `n + 1`.

set a wall
such that the numbers on the left of the wall are unique.


if we found a joint, increase the wall and move the unique number onto the left side of the wall.

```
[1,1,2]

   w
```

joint found, `2 != 1`, move `2` to the left of the wall.

```
[1,2,2]

   w
```

return wall's length
