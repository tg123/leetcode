## Something about line

 * Two Distinct Point
 * [Two-point form](http://en.wikipedia.org/wiki/Linear_equation#Two-point_form)


so a line should be like


```
Line { Point1, Point2 }

function check_on_line(l, p)
    #check p on l using Two-point form 
    p1, p2 <- l
    return (x - p1.x) * (p2.y - p1.y) == (y - p1.y) * (p2.x - p1.x)
    
```


## Loop invariant to find all `Line` and their `point_count`s

Init: Build a collection(`C`) for `Line`s and put first `Line` with first two `Point` into it.


   1. take a new `Point` p
   1. `point_count++` to any `Line` in `C` with `p` on it
   1. if p is not on any `Line` in `C`, create `Line`s with `p` and all former `Point`s
   1. put new `Line`s into `C`


```
foreach p in input
  
  on_some_line = False
  
  foreach l in C
    if check_on_line(l, c)
      l.point_count = l.point_count + 1
      on_some_line = True
      
  if not on_some_line
    foreach _p in input before p
       l = build new Line with _p and p
       add l to C
  
```

### Newly Built Line's point_count

It is wrong that newly built `Line.point_count = 0`. Because the new `Line l` may cross some `Line` in `C`, 
and the cross point may be the in the input points.

In that case, the new `Line` should have its `point_count = count of former p on it` .

Patched `not on_some_line` block


```
  if not on_some_line
    foreach _p in input before p
       l = build new Line with _p and p
       
       l.point_count = count of point input before p on l
       
       add l to C
```

## Finding max

Search `C` to find the max count.



