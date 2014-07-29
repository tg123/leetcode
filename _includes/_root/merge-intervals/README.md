## Merging

```
    +------+               +----------------+
    |      |               |                |
+---------------+      +-------------+      |
|   |      |    |      |   |         |      |
+---+------+----+      +---+---------+------+
     
     figure. 1                figure. 2

```
  
 * figure. 1

  An interval contains another interval, the merged one is the bigger one.
  
 * figure. 2

  An interval overlaps another interval, the merged one is smaller start and bigger end


```
function merge(i1. i2)
  
  return { start = MIN(i1.start, i2.start), end = MAX(i1.end, i2.end) }

```
  
## Merge using a stack [Loop invariant]

Assume that all intervals into a stack and all intervals are sorted by `start`.
The top two intervals in the stack are the smallest in `start`.

If the top two cant be merged into one, the smaller one must cant be merged with any other intervals.
in another word, the smaller one can be put into final result set.


```

stack with sorted intervals

while stack is not empty

  smallest = stack.pop()
  secondary smallest = stack.pop()

  if can merge (overlap or contain)
     merged = merge(smallest, secondary smallest)
     stack.push(merged)
  
  else
  
     put smallest into results
     
     stack.push(secondary smallest)
     
     

```



  
