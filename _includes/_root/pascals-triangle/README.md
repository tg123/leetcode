## Recursion 

from the definition, it is easy to know

```

 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
  
  0 1 2 3 4 


//i start from 0
row[0] = 1
row[last] = 1

row[i] = prev_row[i] + prev_row[i - 1]

```
