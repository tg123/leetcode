## My old days 

[Eight-Queens](http://en.wikipedia.org/wiki/Eight_queens_puzzle) is the first advanced problem I can solve. 'Advanced' here means that I can only solve problems like `counting words` at that time. 

Thanks to [USACO](http://cerberus.delos.com:791/usacogate). More than ten years had passed, I can clearly remember the last answer of `Eight-Queens`, `84136275`.


## [Depth-first search](http://en.wikipedia.org/wiki/Depth-first_search) and [Backtracking](http://en.wikipedia.org/wiki/Backtracking)

DFS is a brute force method, and has a common pattern. 

Pattern for problems with many steps and each step has many choices:


```

selected_choices stores [step_0 : choice_x, step1: choice_y, ...]

dfs(step)

    if all steps had theirs choice
        selected_choices is an answer

    foreah choice in all choices in current step
       
       if choice is possiable
       
         selected_choices[step] = choice
         
         dfs(next step)
  
         // this is called backtracking
         selected_choices[step] = no choice yet or last choice

```

### Apply the pattern to n-Queens

put the queen on the `n * n` chessboard.

 * `steps`: n rows
 * `choices each step`: n grid on current row
 * `possibility checker` : the choosen grid is not sharing same column or diagonal. (the current row has only choosen grid, no need to check)


fake board

```
a boolean[n][n] array to simulate a chessboard

chessboard[row][column] = true is for putting a queen
```


possibility checker function:


```
function check_can_put(row, col)
  
  if queen on same column
    return false
    
  if queen on same diagonal
    return false

```

DFS function

```
function N_queen(row)

    if row > N
       convert chessboard into result
    

    foreah col in current row
       
       if check_can_put(row, col)
       
         // put queen
         chessboard[row][col] = true
         
         N_queen(row + 1)
  
         // take queen away
         chessboard[row][col] = false

```


