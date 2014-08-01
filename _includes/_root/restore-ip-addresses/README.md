## Apply DFS pattern

See DFS pattern in [N-Queens](../n-queens)


  * `steps`: 4 part of an ip-address
  * `choices each step`: 1-3 chars from the string
  * `possibility checker`: the number formed by chars should be less than or equals to 255

### When to use backtracking

In this case, I do not use `stack[pstack] = null` after starting to try another choice.

Because, the value in `stack[pstack]` will not affect any further choice. Rollbacking is not needed and the value will be overwrited.
