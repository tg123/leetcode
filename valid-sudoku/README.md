## Set
 
`HashSet` is a data-structure that can be used for checking duplicates.

use a `HashSet` to check if the row, column and block are valid.

## Comments on Block checking

here use a tricky method to convert `0..8` to `[0,0], [0,1] ... [2,2]`

```
for offset in 0 .. 8
   ox = offset % 3
   oy = offset / 3
```

## More about Sudoku
 * [Sudoku Puzzles - The Rules](http://sudoku.com.au/TheRules.aspx)
 * [Sudoku on wikipedia](http://en.wikipedia.org/wiki/Sudoku)
