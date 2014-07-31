## Number version [Valid Palindrome](../valid-palindrome)

unlike string, we can't use an pointer to access the `i`th of a number.

mathematical method to extract `i`th of the number `x`

```
function ith(x, i)
   return (x / Math.pow(10, i)) % 10
```
