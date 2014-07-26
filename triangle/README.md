## Shortest Path

Everyone doing leetcode should know [Dijkstra's algorithm](http://en.wikipedia.org/wiki/Dijkstra's_algorithm).

This problem is a variant of `Shortest Path`. 
Start from the each point of the triangle's bottom and find the minimum path sum to the top.

```

foreach level in triangle
  
  foreach point in level
    
    point_value = point_value + MIN( left connected point_value, right connected point_value)
  

top level has only 1 point
and that value is the answer

```



