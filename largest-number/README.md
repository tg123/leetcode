## Sort and join

```
[3, 30, 34, 5, 9]

sort into

[9, 5, 34, 3, 30]
```

So, the problem is what is the sorting factor?

### Why `3` > `30` ?

just `brute force`. 

`3` + `30` (`330`)  > `30` + `3` (`303`)

In general, `x` > `y` when `xy` > `yx`.


Notes:

In my code using `.sorted((x, y) -> (y + x).compareTo(x + y))` is because I want a non-ascending order result.
