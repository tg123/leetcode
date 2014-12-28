## [Edit Distance](../edit-distance) == 1

My first submission


```
return minDistance(s, t) == 1;
```

but, leetcode shows `time limit exceeded`.


## Only 1 diff

### Same length

do one pass can know if there is only one different char

### 1 char longer

delete the redundant char will yield two same string

Note:

solved in `O(n)`. [Edit Distance](../edit-distance) == 1 is an `O(n * n)` solution.

