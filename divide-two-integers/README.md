## Simulting via Minus


```
while dividend >= divisor
  dividend = dividend - divisor
  quotient = quotient + 1

```
  
## Accelerating

Above code will exceed time limit. 
We can remove a bit more `divisor`s from `dividend`.


```
acceleration = 1
cached_accelerated_divisor = divisor

while dividend >= divisor
   
   if cached_accelerated_divisor > dividend
       // slow down
       acceleration = acceleration - 1
       cached_accelerated_divisor = cached_accelerated_divisor - divisor
   else
   
       dividend = dividend - cached_accelerated_divisor
       quotient = quotient + acceleration
```


## Overflow

leetcode's testcases covered some edge case like `Integer.MIN_VALUE` and `Integer.MAX_VALUE`, take care.
