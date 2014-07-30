## History: Remember? Forget?

If there is some bad things yesterday, we gotta forget it.

This is the same in finding maximum subarray. ^_^

 * drop pre-subarray if the sum is negative
 * merge current and pre-subarray if the sum of pre-subarray is positive


```
foreach number in A

  if history < 0
    history = number
  else
    history = history + number

  
  max = MAX(history, max) // remember the beautiful day


```
 
