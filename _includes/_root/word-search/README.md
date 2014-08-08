## Apply DFS pattern

See DFS pattern in [N-Queens](../n-queens)

  * `steps`: all chars in the word
  * `choices each step`: jump to the grid on up, down, left or right
  * `possibility checker`: the char in target grid is the same as the next step char


Start a DFS word search on each grid if it has the same char as the first char of `word`. 
If any of them matches the word, stop and return `true`.
