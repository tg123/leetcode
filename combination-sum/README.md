## Apply DFS pattern

See DFS pattern in [N-Queens](../n-queens)


  * `steps`: choose a candidate number
  * `choices each step`: 0..INFINITE times candidate number
  * `possibility checker`: sum of current numbers is less than or equals to target number

### Backtracking

Remove the selected candidate number from steps.
