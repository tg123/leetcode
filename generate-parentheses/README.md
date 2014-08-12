## Recursion

### `generateParenthesis(n - i)` and `generateParenthesis(i)`

This problem is a bit like [Unique Binary Search Trees II](../unique-binary-search-trees-ii).

Put left and right generateParenthesis together is OK.

 * `generateParenthesis(n - i)` + `generateParenthesis(i)`
 * `generateParenthesis(i)` + `generateParenthesis(n - i)`


### Special `i = 1`: `generateParenthesis(n - 1)` and `generateParenthesis(1)`

Another new way to generate parenthesis.

 * Surrounding  :`(` + `generateParenthesis(n)` + `)` 

Same as `generateParenthesis(n - i)` and `generateParenthesis(i)`
 
 * `generateParenthesis(n - 1)` + `()`
 * `()` + `generateParenthesis(n - 1)`
