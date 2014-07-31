## Just Combine [Valid Sudoku](../valid-sudoku) and [N-Queens](../n-queens)

the only difference form [N-Queens](../n-queens) is the `possibility checker`. 

but, good news is that we have done [Valid Sudoku](../valid-sudoku).


## Time Limit 

The first version looks like [N-Queens](../n-queens) may exceed the time limit. 

### Fail fast.

In this problem, if any grid is not solved, trying any further is needless.

So, let `solveSudoku` return a flag to warn this way is blocked.
