## Simulating

Create a fake paper, write every character on it.

```
   *     *     *  
   *   * *   *
   * *   * * 
   *     *
   |r-2+1|
   
   col = (row - 2 + 1) * (len(s) / (row + row - 2) + 1)
```

paper's area is `col` * `row`.
