## Deal with [carry](http://en.wikipedia.org/wiki/Carry_(arithmetic))

The bad news after the add one to digits is resulting a carry. 

when there is a carry, `digit[i]` should transfer `digit[i] / 10` to its left digit (`digit[i -1]`).
`digit[i]` will be `digit[i] % 10` after transfering.

So, our work is to start from right most digit and make sure each digit is the right value.


```
foreach index from right most to left most in digits
  
  // transfer
  digits[i - 1] = digits[i - 1] + digits[i] / 10
  
  digits[i] = digits[i] % 10

```

Sometimes, the left more digit will too result a carry, so make sure there is enough space to put the new transfered digit.
