## Guessing

sum of three number equals to zero, there must be at least one `negative number` and one `positive number`.

make the input array sorted, `negative numbers` should be on the left end and `positive numbers` should be on the right end.

choose a `negative number` and a `positive number`, and search from the `negative number` to the positive number, find a number:

such that `the number` + `negative number` + `positive number` = 0.

if there is no `negative number` or `positive number`, we can sure no three sum equals to zero.


```

sort input array num

n = 0
p = end of array

while num[n] is negative and num[p] is positive

  foreach i between n and p
    if num[i] + num[n] + num[p] == 0
      add result to collection
      reset n = 0
      p = p - 1
      
      try another loop


```
